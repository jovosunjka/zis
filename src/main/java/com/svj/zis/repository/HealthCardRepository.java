package com.svj.zis.repository;

import com.svj.zis.model.Lekari;
import com.svj.zis.model.ZdravstveniKarton;
import com.svj.zis.model.ZdravstveniKartoni;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.modules.XMLResource;


@Repository
public class HealthCardRepository extends ResourceRepository {

    private String collectionId = "/db/zis/zdravstveni_kartoni";
    private String documentId = "zdravstveni_kartoni.xml";
    private ClassPathResource zdravstveniKartoniXml = new ClassPathResource("xml/" + documentId);

    public String getAllHealthCards() {
        try {
            XMLResource resource = getResource(collectionId, documentId);

            System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");


            //ZdravstveniKartoni zdravstveniKartoni = (ZdravstveniKartoni) super.unmarshaller.unmarshal(resource.getContentAsDOM());

            //return zdravstveniKartoni;

            return (String) resource.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveAll() throws Exception {
        ZdravstveniKartoni zdravstveniKartoni = (ZdravstveniKartoni) super.unmarshaller.unmarshal(zdravstveniKartoniXml.getFile());
        super.saveAll(collectionId, documentId, zdravstveniKartoni);
    }
}