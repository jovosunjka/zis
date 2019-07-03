package com.svj.zis.repository;

import com.svj.zis.model.Lekovi;
import com.svj.zis.model.Pregledi;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.modules.XMLResource;


@Repository
public class MedicamentRepository extends ResourceRepository{
    private String collectionId = "/db/zis/lekovi";
    private String documentId = "lekovi.xml";
    private ClassPathResource lekoviXml = new ClassPathResource("xml/" + documentId);


    public String getAllReviews() {
        try {
            XMLResource resource = getResource(collectionId, documentId);

            System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");


            //Lekovi lekovi = (Lekovi) super.unmarshaller.unmarshal(resource.getContentAsDOM());

            //return lekovi;

            return (String) resource.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveAll() throws Exception {
        Lekovi lekovi = (Lekovi) super.unmarshaller.unmarshal(lekoviXml.getFile());
        super.saveAll(collectionId, documentId, lekovi);
    }
}
