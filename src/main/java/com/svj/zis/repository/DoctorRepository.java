package com.svj.zis.repository;

import com.svj.zis.model.Lekari;
import org.exist.xmldb.EXistResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XQueryService;

@Repository
public class DoctorRepository extends ResourceRepository {

    private String collectionId = "/db/zis/lekari";
    private String documentId = "lekari.xml";
    private ClassPathResource lekariXml = new ClassPathResource("xml/" + documentId);
    private ClassPathResource findDoctorByIdXQuery = new ClassPathResource("xqueries/find_doctor_by_id.xqy");


    public String getAllDoctors() {
        try {
            XMLResource resource = getResource(collectionId, documentId);

            System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");


            //Lekari lekari = (Lekari) super.unmarshaller.unmarshal(resource.getContentAsDOM());

            //return lekari;

            return (String) resource.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String findById(String id) throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String path = findDoctorByIdXQuery.getFile().getPath();
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

    public void saveAll() throws Exception {
        Lekari lekari = (Lekari) super.unmarshaller.unmarshal(lekariXml.getFile());
        super.saveAll(collectionId, documentId, lekari);
    }
}
