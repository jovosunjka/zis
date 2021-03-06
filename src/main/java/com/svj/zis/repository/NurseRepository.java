package com.svj.zis.repository;

import com.svj.zis.model.MedicinskeSestre;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;


@Repository
public class NurseRepository extends ResourceRepository {

    private String collectionId = "/db/zis/medicinske_sestre";
    private String documentId = "medicinske_sestre.xml";
    private ClassPathResource medicinskeSestrXml = new ClassPathResource("xml/" + documentId);

    public String getAllNurses() {
        try {
            XMLResource resource = getResource(collectionId, documentId);

            System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");


            //MedicinskeSestre medicinskeSestre = (MedicinskeSestre) super.unmarshaller.unmarshal(resource.getContentAsDOM());

            //return medicinskeSestre;

            return (String) resource.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveAll() throws Exception {
        JAXBContext context = JAXBContext.newInstance("com.svj.zis.model");
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //MedicinskeSestre medicinskeSestre = (MedicinskeSestre) super.unmarshaller.unmarshal(medicinskeSestrXml.getFile());
        MedicinskeSestre medicinskeSestre = (MedicinskeSestre) unmarshaller.unmarshal(medicinskeSestrXml.getFile());
        super.saveAll(collectionId, documentId, medicinskeSestre);
    }
}
