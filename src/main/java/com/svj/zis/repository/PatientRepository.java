package com.svj.zis.repository;

import com.svj.zis.model.Pacijenti;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.modules.XMLResource;


@Repository
public class PatientRepository extends ResourceRepository {

    private String collectionId = "/db/zis/pacijenti";
    private String documentId = "pacijenti.xml";
    private ClassPathResource pacijentiXml = new ClassPathResource("xml/" + documentId);

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
        Pacijenti pacijenti = (Pacijenti) super.unmarshaller.unmarshal(pacijentiXml.getFile());
        super.saveAll(collectionId, documentId, pacijenti);
    }
}