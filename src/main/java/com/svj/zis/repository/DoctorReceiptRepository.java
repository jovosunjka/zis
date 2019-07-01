package com.svj.zis.repository;

import com.svj.zis.model.LekarskiRecepti;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.modules.XMLResource;


@Repository
public class DoctorReceiptRepository extends ResourceRepository {

    private String collectionId = "/db/zis/lekarski_recepti";
    private String documentId = "lekarski_recepti.xml";
    private ClassPathResource lekarskiReceptiXml = new ClassPathResource("xml/" + documentId);

    public String getAllDoctorReceipts() {
        try {
            XMLResource resource = getResource(collectionId, documentId);

            System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");


            //LekarskiRecept lekarskiRecepti = (LekarskiRecept) super.unmarshaller.unmarshal(resource.getContentAsDOM());

            //return lekarskiRecepti;

            return (String) resource.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveAll() throws Exception {
        LekarskiRecepti lekarskiRecepti = (LekarskiRecepti) super.unmarshaller.unmarshal(lekarskiReceptiXml.getFile());
        super.saveAll(collectionId, documentId, lekarskiRecepti);
    }
}
