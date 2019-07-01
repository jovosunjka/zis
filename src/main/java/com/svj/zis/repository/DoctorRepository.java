package com.svj.zis.repository;

import com.svj.zis.model.Lekari;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.modules.XMLResource;

@Repository
public class DoctorRepository extends ResourceRepository {

    private String collectionId = "/db/zis/lekari";
    private String documentId = "lekari.xml";
    private ClassPathResource lekariXml = new ClassPathResource("xml/" + documentId);

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

    public void saveAll() throws Exception {
        Lekari lekari = (Lekari) super.unmarshaller.unmarshal(lekariXml.getFile());
        super.saveAll(collectionId, documentId, lekari);
    }
}
