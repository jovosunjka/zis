package com.svj.zis.repository;

import com.svj.zis.model.Izvestaji;
import com.svj.zis.model.Pacijent;
import org.exist.xmldb.EXistResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XQueryService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

@Repository
public class ReportRepository extends ResourceRepository {

    private String collectionId = "/db/zis/izvestaji";
    private String documentId = "izvestaji.xml";
    private ClassPathResource izvestajiXml = new ClassPathResource("xml/" + documentId);
    private ClassPathResource findReportsByPatientIdXQuery = new ClassPathResource("xqueries/find_reports_by_patient_id.xqy");


    public String getAllReports() {
        try {
            XMLResource resource = getResource(collectionId, documentId);

            System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");


            //Izvestaji izvestaji = (Izvestaji) super.unmarshaller.unmarshal(resource.getContentAsDOM());

            //return izvestaji;

            return (String) resource.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveAll() throws Exception {
        JAXBContext context = JAXBContext.newInstance("com.svj.zis.model");
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //Izvestaji izvestaji = (Izvestaji) super.unmarshaller.unmarshal(izvestajiXml.getFile());
        Izvestaji izvestaji = (Izvestaji) unmarshaller.unmarshal(izvestajiXml.getFile());
        super.saveAll(collectionId, documentId, izvestaji);
    }

    public String getReports(String idOfPatient) throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String path = findReportsByPatientIdXQuery.getFile().getPath();
        String contentStr = loadFileContent(path);
        String sadrzajUpita = String.format(contentStr, idOfPatient);
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
