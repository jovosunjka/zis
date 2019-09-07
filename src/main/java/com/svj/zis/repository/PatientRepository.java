package com.svj.zis.repository;

import com.svj.zis.model.Pacijent;
import com.svj.zis.model.Pacijenti;
import com.svj.zis.util.template.XUpdateTemplate;
import org.exist.xmldb.EXistResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XQueryService;
import org.xmldb.api.modules.XUpdateQueryService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;


@Repository
public class PatientRepository extends ResourceRepository {

    private String collectionId = "/db/zis/pacijenti";
    private String documentId = "pacijenti.xml";
    private ClassPathResource pacijentiXml = new ClassPathResource("xml/" + documentId);
    private ClassPathResource findPatientByUserIdXQuery = new ClassPathResource("xqueries/find_patient_by_user_id.xqy");
    private ClassPathResource findPatientByPatientIdXQuery = new ClassPathResource("xqueries/find_patient_by_patient_id.xqy");
    private ClassPathResource findNotificationsByUserIdXQuery = new ClassPathResource("xqueries/find_notifications_by_user_id.xqy");


    public String getAllPatients() {
        try {
            XMLResource resource = getResource(collectionId, documentId);

            System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");


            //Pacijenti pacijenti = (Pacijenti) super.unmarshaller.unmarshal(resource.getContentAsDOM());

            //return pacijenti;

            return (String) resource.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveAll() throws Exception {
        JAXBContext context = JAXBContext.newInstance("com.svj.zis.model");
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //Pacijenti pacijenti = (Pacijenti) super.unmarshaller.unmarshal(pacijentiXml.getFile());
        Pacijenti pacijenti = (Pacijenti) unmarshaller.unmarshal(pacijentiXml.getFile());
        super.saveAll(collectionId, documentId, pacijenti);
    }

    private Pacijent findBySomeId(String path, String id) throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String contentStr = loadFileContent(path);
        String sadrzajUpita = String.format(contentStr, id);
        CompiledExpression compiledExpression = xQueryService.compile(sadrzajUpita);
        ResourceSet resourceSet = xQueryService.execute(compiledExpression);
        ResourceIterator i = resourceSet.getIterator();

        org.xmldb.api.base.Resource resource = null;
        if(i.hasMoreResources()) {

            try {
                resource = i.nextResource();
                XMLResource xmlResource = (XMLResource) resource;
                System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");

                JAXBContext context = JAXBContext.newInstance("com.svj.zis.model");
                Unmarshaller unmarshaller = context.createUnmarshaller();
                //Pacijent pacijent = (Pacijent) super.unmarshaller.unmarshal(xmlResource.getContentAsDOM());
                Pacijent pacijent = (Pacijent) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
                return pacijent;
            } finally {

                // don't forget to cleanup resources
                try {
                    ((EXistResource)resource).freeResources();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }

        return null;
    }

    public Pacijent findByUserId(String idOfUser) throws Exception {
       return findBySomeId(findPatientByUserIdXQuery.getFile().getPath(), idOfUser);
    }

    public Pacijent findByPatientId(String idOfPatient) throws Exception {
        return findBySomeId(findPatientByPatientIdXQuery.getFile().getPath(), idOfPatient);
    }

    public void updatePatientAddNotification(String patientId, String idOfReview, String oldDateAndTime, String newDateAndTime, boolean firstNotification) throws Exception {
        LocalDateTime currentDataTime = LocalDateTime.now();

        String monthStr = "" + currentDataTime.getMonthValue();
        if(monthStr.length() == 1) {
            monthStr = "0" + monthStr;
        }

        String dayStr = "" + currentDataTime.getDayOfMonth();
        if(dayStr.length() == 1) {
            dayStr = "0" + dayStr;
        }

        String hourStr = "" + currentDataTime.getHour();
        if(hourStr.length() == 1) {
            hourStr = "0" + hourStr;
        }

        String minuteStr = "" + currentDataTime.getMinute();
        if(minuteStr.length() == 1) {
            minuteStr = "0" + minuteStr;
        }

        String secondStr = "" + currentDataTime.getSecond();
        if(secondStr.length() == 1) {
            secondStr = "0" + secondStr;
        }

        String message = "Review ("+idOfReview+") scheduled for "+oldDateAndTime+" has been moved to " + newDateAndTime + ".";

        Collection collection = getCollection(collectionId);

        // get an instance of xupdate query service
        System.out.println("[INFO] Fetching XUpdate service for the collection.");
        XUpdateQueryService xupdateService = (XUpdateQueryService) collection.getService("XUpdateQueryService", "1.0");
        xupdateService.setProperty("indent", "yes");

        // update patient's content
        String contextXPathElement;
        String template;

        if (firstNotification) {
            contextXPathElement = String.format("/pacijenti/osobe:pacijent[@id = '%s']" +
                    "/osobe:obavestenja", patientId);
            template = XUpdateTemplate.APPEND;
        }
        else {
            contextXPathElement = String.format("/pacijenti/osobe:pacijent[@id = '%s']" +
                    "/osobe:obavestenja/osobe:obavestenje[1]", patientId);
            template = XUpdateTemplate.INSERT_BEFORE;
        }
        // compile and execute xupdate expressions
        System.out.println("[INFO] Updating " + contextXPathElement + " node.");
        String targetNamespace = "http://www.svj.com/zis/kolekcije";
        String xmlFragment = "<osobe:obavestenje datum=\""+currentDataTime.getYear()+"-"+monthStr+"-"+dayStr+"T"+hourStr+":"+minuteStr+":"+secondStr+"\">"+message+"</osobe:obavestenje>";
        String xUpdateExpression = String.format(template, targetNamespace,
                "xmlns:osobe=\"http://www.svj.com/zis/osobe\"", contextXPathElement, xmlFragment);
        System.out.println("*** xUpdateExpression:");
        System.out.println(xUpdateExpression);
        long mods = xupdateService.updateResource(documentId, xUpdateExpression);
        System.out.println("[INFO] " + mods + " modifications processed.");
    }

    public String getNotifications(String idOfUser) throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String contentStr = loadFileContent(findNotificationsByUserIdXQuery.getFile().getPath());
        String sadrzajUpita = String.format(contentStr, idOfUser);
        CompiledExpression compiledExpression = xQueryService.compile(sadrzajUpita);
        ResourceSet resourceSet = xQueryService.execute(compiledExpression);
        ResourceIterator i = resourceSet.getIterator();

        org.xmldb.api.base.Resource resource = null;
        if(i.hasMoreResources()) {

            try {
                resource = i.nextResource();
                return (String) resource.getContent();
            } finally {

                // don't forget to cleanup resources
                try {
                    ((EXistResource)resource).freeResources();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }

        return null;
    }
}