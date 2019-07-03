package com.svj.zis.repository;

import com.svj.zis.model.Pregledi;
import com.svj.zis.util.template.XUpdateTemplate;
import org.exist.xmldb.EXistResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XQueryService;
import org.xmldb.api.modules.XUpdateQueryService;


@Repository
public class ReviewRepository extends ResourceRepository {

    private String collectionId = "/db/zis/pregledi";
    private String documentId = "pregledi.xml";
    private ClassPathResource preglediXml = new ClassPathResource("xml/" + documentId);
    private ClassPathResource findFreeReviewsByDoctorIdXQuery = new ClassPathResource("xqueries/find_free_reviews_by_doctor_id.xqy");
    private ClassPathResource findOrderedReviewsByPatientIdXQuery = new ClassPathResource("xqueries/find_ordered_reviews_by_patient_id.xqy");


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

    public String findFreeReviewsByDoctorId(String doctorId) throws Exception {
        return findReviews(findFreeReviewsByDoctorIdXQuery.getFile().getPath(), doctorId);
    }

    public String findOrederedReviewsByPatientId(String patientId) throws Exception {
        return findReviews(findOrderedReviewsByPatientIdXQuery.getFile().getPath(), patientId);
    }

    public String findReviews(String path, String id) throws Exception {
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



    public void updateReview(String idOfPatient, String idOfReview) throws Exception {
        Collection collection = getCollection(collectionId);

        // get an instance of xupdate query service
        System.out.println("[INFO] Fetching XUpdate service for the collection.");
        XUpdateQueryService xupdateService = (XUpdateQueryService) collection.getService("XUpdateQueryService", "1.0");
        xupdateService.setProperty("indent", "yes");

        String contextXPath = String.format("/pregledi/dokumenti:pregled[@id = '%s']" +
                "/dokumenti:pacijent/@id", idOfReview);

        // compile and execute xupdate expressions
        System.out.println("[INFO] Updating " + contextXPath + " node.");
        String targetNamespace = "http://www.svj.com/zis/kolekcije";
        String xUpdateExpression = String.format(XUpdateTemplate.UPDATE, targetNamespace,
                "xmlns:dokumenti=\"http://www.svj.com/zis/dokumenti\"", contextXPath, idOfPatient);
        System.out.println("*** xUpdateExpression:");
        System.out.println(xUpdateExpression);
        long mods = xupdateService.updateResource(documentId, xUpdateExpression);
        System.out.println("[INFO] " + mods + " modifications processed.");
    }
}
