package com.svj.zis.repository;

import com.svj.zis.model.Pregledi;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.modules.XMLResource;


@Repository
public class ReviewRepository extends ResourceRepository {

    private String collectionId = "/db/zis/pregledi";
    private String documentId = "pregledi.xml";
    private ClassPathResource preglediXml = new ClassPathResource("xml/" + documentId);

    public String getAllReviews() {
        try {
            XMLResource resource = getResource(collectionId, documentId);

            System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");


            //Lekari pregledi = (Lekari) super.unmarshaller.unmarshal(resource.getContentAsDOM());

            //return pregledi;

            return (String) resource.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveAll() throws Exception {
        Pregledi pregledi = (Pregledi) super.unmarshaller.unmarshal(preglediXml.getFile());
        super.saveAll(collectionId, documentId, pregledi);
    }
}
