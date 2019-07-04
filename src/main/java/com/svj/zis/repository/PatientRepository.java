package com.svj.zis.repository;

import com.svj.zis.model.Pacijent;
import com.svj.zis.model.Pacijenti;
import org.exist.xmldb.EXistResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XQueryService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;


@Repository
public class PatientRepository extends ResourceRepository {

    private String collectionId = "/db/zis/pacijenti";
    private String documentId = "pacijenti.xml";
    private ClassPathResource pacijentiXml = new ClassPathResource("xml/" + documentId);
    private ClassPathResource findPatientByUserIdXQuery = new ClassPathResource("xqueries/find_patient_by_user_id.xqy");
    private ClassPathResource findPatientByPatientIdXQuery = new ClassPathResource("xqueries/find_patient_by_patient_id.xqy");

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
        JAXBContext context = JAXBContext.newInstance("com.svj.zis.model");
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //Pacijenti pacijenti = (Pacijenti) super.unmarshaller.unmarshal(pacijentiXml.getFile());
        Pacijenti pacijenti = (Pacijenti) unmarshaller.unmarshal(pacijentiXml.getFile());
        super.saveAll(collectionId, documentId, pacijenti);
    }

    private Pacijent findBySomeId(String path, String id) throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String contentStr = loadFileContent(path);
        String sadrzajUpita = String.format(contentStr, id);
        CompiledExpression compiledExpression = xQueryService.compile(sadrzajUpita);
        ResourceSet resourceSet = xQueryService.execute(compiledExpression);
        ResourceIterator i = resourceSet.getIterator();

        org.xmldb.api.base.Resource resource = null;
        if(i.hasMoreResources()) {

            try {
                resource = i.nextResource();
                XMLResource xmlResource = (XMLResource) resource;
                System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");

                JAXBContext context = JAXBContext.newInstance("com.svj.zis.model");
                Unmarshaller unmarshaller = context.createUnmarshaller();
                //Pacijent pacijent = (Pacijent) super.unmarshaller.unmarshal(xmlResource.getContentAsDOM());
                Pacijent pacijent = (Pacijent) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
                return pacijent;
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

    public Pacijent findByUserId(String idOfUser) throws Exception {
       return findBySomeId(findPatientByUserIdXQuery.getFile().getPath(), idOfUser);
    }

    public Pacijent findByPatientId(String idOfPatient) throws Exception {
        return findBySomeId(findPatientByPatientIdXQuery.getFile().getPath(), idOfPatient);
    }
}