package com.svj.zis.repository;

import com.svj.zis.model.Lekar;
import com.svj.zis.model.Lekari;
import com.svj.zis.model.Pacijent;
import org.exist.xmldb.EXistResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XQueryService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

@Repository
public class DoctorRepository extends ResourceRepository {

    private String collectionId = "/db/zis/lekari";
    private String documentId = "lekari.xml";
    private ClassPathResource lekariXml = new ClassPathResource("xml/" + documentId);
    private ClassPathResource findDoctorByDoctorIdXQuery = new ClassPathResource("xqueries/find_doctor_by_doctor_id.xqy");
    private ClassPathResource findNotOverburdenedDoctorsXQuery = new ClassPathResource("xqueries/find_not_overburdened_doctors.xqy");
    private ClassPathResource findDoctorByUserIdXQuery = new ClassPathResource("xqueries/find_doctor_by_user_id.xqy");

    @Value("${number-of-patients-per-doctor}")
    private int numberOfPatientsPerDoctor;

    public String getAllDoctors() {
        try {
            XMLResource resource = getResource(collectionId, documentId);

            System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");


            //Lekari lekari = (Lekari) super.unmarshaller.unmarshal(resource.getContentAsDOM());

            //return lekari;

            return (String) resource.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getNotOverburdenedDoctors() throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String contentStr = loadFileContent(findNotOverburdenedDoctorsXQuery.getFile().getPath());
        String sadrzajUpita = String.format(contentStr, ""+numberOfPatientsPerDoctor);
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


    private org.xmldb.api.base.Resource findResourceBySomeId(String path, String id) throws Exception {
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
                return resource;
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

    public String findByDoctorId(String idOfDoctor) throws Exception {
        org.xmldb.api.base.Resource resource = findResourceBySomeId(findDoctorByDoctorIdXQuery.getFile().getPath(), idOfDoctor);
        return (String) resource.getContent();
    }

    public Lekar findDoctorByDoctorId(String idOfDoctor) throws Exception {
        org.xmldb.api.base.Resource resource = findResourceBySomeId(findDoctorByDoctorIdXQuery.getFile().getPath(), idOfDoctor);
        XMLResource xmlResource = (XMLResource) resource;
        System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");

        JAXBContext context = JAXBContext.newInstance("com.svj.zis.model");
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //Lekar lekar = (Lekar) super.unmarshaller.unmarshal(xmlResource.getContentAsDOM());
        Lekar lekar = (Lekar) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
        return lekar;
    }

    public Lekar findByUserId(String idOfUser) throws Exception {
        org.xmldb.api.base.Resource resource = findResourceBySomeId(findDoctorByUserIdXQuery.getFile().getPath(), idOfUser);
        XMLResource xmlResource = (XMLResource) resource;
        System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");

        JAXBContext context = JAXBContext.newInstance("com.svj.zis.model");
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //Lekar lekar = (Lekar) super.unmarshaller.unmarshal(xmlResource.getContentAsDOM());
        Lekar lekar = (Lekar) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
        return lekar;
    }

    public void saveAll() throws Exception {
        JAXBContext context = JAXBContext.newInstance("com.svj.zis.model");
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //Lekari lekari = (Lekari) super.unmarshaller.unmarshal(lekariXml.getFile());
        Lekari lekari = (Lekari) unmarshaller.unmarshal(lekariXml.getFile());
        super.saveAll(collectionId, documentId, lekari);
    }

}
