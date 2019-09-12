package com.svj.zis.repository;

import com.svj.zis.model.Izvestaji;
import com.svj.zis.model.Lekar;
import com.svj.zis.model.Pacijent;
import com.svj.zis.model.ZdravstveniKarton;
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
import java.time.LocalDate;
import java.util.UUID;

@Repository
public class ReportRepository extends ResourceRepository {

    private String collectionId = "/db/zis/izvestaji";
    private String documentId = "izvestaji.xml";
    private ClassPathResource izvestajiXml = new ClassPathResource("xml/" + documentId);
    private ClassPathResource findReportsByPatientIdXQuery = new ClassPathResource("xqueries/find_reports_by_patient_id.xqy");
    private ClassPathResource findReportByReportIdXQuery = new ClassPathResource("xqueries/find_report_by_report_id.xqy");
    private ClassPathResource findReportsLengthXQuery = new ClassPathResource("xqueries/find_reports_length.xqy");


    public String getAllReports() {
        try {
            XMLResource resource = getResource(collectionId, documentId);

            System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");


            //Izvestaji izvestaji = (Izvestaji) super.unmarshaller.unmarshal(resource.getContentAsDOM());

            //return izvestaji;

            return (String) resource.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Izvestaji getReports() {
        try {
            XMLResource resource = getResource(collectionId, documentId);

            System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");

            JAXBContext context = JAXBContext.newInstance("com.svj.zis.model");
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Izvestaji izvestaji = (Izvestaji) unmarshaller.unmarshal(resource.getContentAsDOM());

            return izvestaji;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveAll() throws Exception {
        JAXBContext context = JAXBContext.newInstance("com.svj.zis.model");
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //Izvestaji izvestaji = (Izvestaji) super.unmarshaller.unmarshal(izvestajiXml.getFile());
        Izvestaji izvestaji = (Izvestaji) unmarshaller.unmarshal(izvestajiXml.getFile());
        super.saveAll(collectionId, documentId, izvestaji);
    }

    public String getReports(String idOfPatient) throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String path = findReportsByPatientIdXQuery.getFile().getPath();
        String contentStr = loadFileContent(path);
        String sadrzajUpita = String.format(contentStr, idOfPatient);
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

    public String getReport(String id) throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String path = findReportByReportIdXQuery.getFile().getPath();
        String contentStr = loadFileContent(path);
        String sadrzajUpita = String.format(contentStr, id);
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

    private String prepareMixElement(String str) {
        String[] tokens = str.split("\\s+");  //  \t \n \r \f
        String url;
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].startsWith("|") && tokens[i].endsWith("|")) {
                url = tokens[i].substring(1, tokens.length-1); // izostavljamo | na pocetku i na kraju
                tokens[i] = "<dokumenti:link id=\""+url+"\" href=\""+url+"\" rel=\"pred:referencaNaDokument\"/>";
            }
        }

        return String.join(" ", tokens);
    }

    private int getReportsLength() throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String path = findReportsLengthXQuery.getFile().getPath();
        String sadrzajUpita = loadFileContent(path);
        CompiledExpression compiledExpression = xQueryService.compile(sadrzajUpita);
        ResourceSet resourceSet = xQueryService.execute(compiledExpression);
        ResourceIterator i = resourceSet.getIterator();

        org.xmldb.api.base.Resource resource = null;
        if(i.hasMoreResources()) {

            try {
                resource = i.nextResource();
                return Integer.parseInt((String) resource.getContent());
            } finally {

                // don't forget to cleanup resources
                try {
                    ((EXistResource)resource).freeResources();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }

        return -10000;
    }

    public String makeReport(Lekar lekar, ZdravstveniKarton zdravstveniKarton, String dijagnoza, String anamneza,
                           String terapija) throws Exception {
        String newReportIdNum = "" + (getReportsLength() + 1);
        String newReportId = "http://www.svj.com/zis/dokumenti/izvestaj/"+newReportIdNum;
        //anamneza = prepareMixElement(anamneza);
        //terapija = prepareMixElement(terapija);

        LocalDate datum = LocalDate.now();

        String monthStr = "" + datum.getMonthValue();
        if(monthStr.length() == 1) {
            monthStr = "0" + monthStr;
        }

        String dayStr = "" + datum.getDayOfMonth();
        if(dayStr.length() == 1) {
            dayStr = "0" + dayStr;
        }

        Collection collection = getCollection(collectionId);

        // get an instance of xupdate query service
        System.out.println("[INFO] Fetching XUpdate service for the collection.");
        XUpdateQueryService xupdateService = (XUpdateQueryService) collection.getService("XUpdateQueryService", "1.0");
        xupdateService.setProperty("indent", "yes");

        // update patient's content
        String contextXPathElement = "/izvestaji";

        // compile and execute xupdate expressions
        System.out.println("[INFO] Updating " + contextXPathElement + " node.");
        String targetNamespace = "http://www.svj.com/zis/kolekcije";
        String xmlFragment = "<dokumenti:izvestaj about=\""+newReportId+"\" oznaka=\"iz_oznaka_"+ UUID.randomUUID().toString() +"\"  id=\""+newReportId+"\">" +
                                "<dokumenti:zdravstveni_karton id=\""+zdravstveniKarton.getId()+"\" broj_zdravstvenog_kartona=\""+zdravstveniKarton.getBrojKartona()+"\" broj_zdrastvene_knjizice=\""+zdravstveniKarton.getBrojZdrastveneKnjizice()+"\" href=\""+zdravstveniKarton.getId()+"\" rel=\"pred:zdravstveniKarton\"/>" +
                                "<dokumenti:dijagnoza datatype=\"xs:string\" property=\"pred:dijagnoza\">"+dijagnoza+"</dokumenti:dijagnoza>" +
                                "<dokumenti:anamneza  datatype=\"xs:string\" property=\"pred:anamneza\">" + anamneza + "</dokumenti:anamneza>" +
                                "<dokumenti:terapija  datatype=\"xs:string\" property=\"pred:terapija\">" + terapija + "</dokumenti:terapija>" +
                                "<dokumenti:datum datatype=\"xs:date\" property=\"pred:datum\">"+datum.getYear()+"-"+monthStr+"-"+dayStr+"</dokumenti:datum>" +
                                "<dokumenti:osigurano_lice id=\""+zdravstveniKarton.getPacijentoviPodaci().getPacijent().getId()+"\" rel=\"pred:osiguranoLice\" href=\""+zdravstveniKarton.getPacijentoviPodaci().getPacijent().getId()+"\">" +
                                    "<dokumenti:ime>"+zdravstveniKarton.getPacijentoviPodaci().getIme()+"</dokumenti:ime>" +
                                    "<dokumenti:prezime>"+zdravstveniKarton.getPacijentoviPodaci().getPrezime()+"</dokumenti:prezime>" +
                                "</dokumenti:osigurano_lice>" +
                                "<dokumenti:lekar id=\""+lekar.getId()+"\" rel=\"pred:lekar\" href=\""+lekar.getId()+"\">" +
                                    "<dokumenti:ime>"+lekar.getIme()+"</dokumenti:ime>" +
                                    "<dokumenti:prezime>"+lekar.getPrezime()+"</dokumenti:prezime>" +
                                "</dokumenti:lekar>" +
                            "</dokumenti:izvestaj>";
        String xUpdateExpression = String.format(XUpdateTemplate.APPEND, targetNamespace,
                "xmlns:dokumenti=\"http://www.svj.com/zis/dokumenti\"", contextXPathElement, xmlFragment);
        System.out.println("*** xUpdateExpression:");
        System.out.println(xUpdateExpression);
        long mods = xupdateService.updateResource(documentId, xUpdateExpression);
        System.out.println("[INFO] " + mods + " modifications processed.");

        return newReportIdNum;
    }
}
