package com.svj.zis.repository;

import com.svj.zis.model.UputiZaLaboratoriju;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.modules.XMLResource;


@Repository
public class ReferralForLabRepository extends ResourceRepository {

    private String collectionId = "/db/zis/uputi_za_laboratoriju";
    private String documentId = "uputi_za_laboratoriju.xml";
    private ClassPathResource uputiZaLaboratorijuXml = new ClassPathResource("xml/" + documentId);

    public String getAllReferralsForLab() {
        try {
            XMLResource resource = getResource(collectionId, documentId);

            System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");


            //UputiZaLaboratoriju uputiZaLaboratoriju = (UputiZaLaboratoriju) super.unmarshaller.unmarshal(resource.getContentAsDOM());

            //return uputiZaLaboratoriju;

            return (String) resource.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveAll() throws Exception {
        UputiZaLaboratoriju uputiZaLaboratoriju = (UputiZaLaboratoriju) super.unmarshaller.unmarshal(uputiZaLaboratorijuXml.getFile());
        super.saveAll(collectionId, documentId, uputiZaLaboratoriju);
    }
}