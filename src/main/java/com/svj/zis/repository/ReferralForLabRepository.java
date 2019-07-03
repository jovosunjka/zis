package com.svj.zis.repository;

import com.svj.zis.model.UputiZaLaboratoriju;
import org.exist.xmldb.EXistResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XQueryService;


@Repository
public class ReferralForLabRepository extends ResourceRepository {

    private String collectionId = "/db/zis/uputi_za_laboratoriju";
    private String documentId = "uputi_za_laboratoriju.xml";
    private ClassPathResource uputiZaLaboratorijuXml = new ClassPathResource("xml/" + documentId);
    private ClassPathResource findReferralsForLabByPatientIdXQuery = new ClassPathResource("xqueries/find_referrals_for_lab_by_number_of_heath_card.xqy");


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

    public String getReferralsForLab(String numberOfHeathCard) throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String path = findReferralsForLabByPatientIdXQuery.getFile().getPath();
        String contentStr = loadFileContent(path);
        String sadrzajUpita = String.format(contentStr, numberOfHeathCard);
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
}