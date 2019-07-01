package com.svj.zis.repository;

import com.svj.zis.model.UputiZaSpecijalistickiPregled;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.modules.XMLResource;


@Repository
public class ReferralForSpecialistExaminationRepository extends ResourceRepository {

    private String collectionId = "/db/zis/uputi_za_specijalisticki_pregled";
    private String documentId = "uputi_za_specijalisticki_pregled.xml";
    private ClassPathResource uputiZaSpecijalistickiPregledXml = new ClassPathResource("xml/" + documentId);

    public String getAllReferralsForSpecialistExamination() {
        try {
            XMLResource resource = getResource(collectionId, documentId);

            System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");


            //UputiZaSpecijalistickiPregled uputiZaSpecijalistickiPregled = (UputiZaSpecijalistickiPregled) super.unmarshaller.unmarshal(resource.getContentAsDOM());

            //return uputiZaSpecijalistickiPregled;

            return (String) resource.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveAll() throws Exception {
        UputiZaSpecijalistickiPregled uputiZaSpecijalistickiPregled = (UputiZaSpecijalistickiPregled) super.unmarshaller.unmarshal(uputiZaSpecijalistickiPregledXml.getFile());
        super.saveAll(collectionId, documentId, uputiZaSpecijalistickiPregled);
    }
}
