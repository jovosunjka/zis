package com.svj.zis.repository;

import com.svj.zis.model.Lek;
import com.svj.zis.model.Lekovi;
import com.svj.zis.model.Pacijent;
import com.svj.zis.model.Pregledi;
import org.exist.xmldb.EXistResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XQueryService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;


@Repository
public class MedicamentRepository extends ResourceRepository{
    private String collectionId = "/db/zis/lekovi";
    private String documentId = "lekovi.xml";
    private ClassPathResource lekoviXml = new ClassPathResource("xml/" + documentId);
    private ClassPathResource findMedicamentByIdXQuery = new ClassPathResource("xqueries/find_medicament_by_id.xqy");
    private ClassPathResource findMedicamentByCodeXQuery = new ClassPathResource("xqueries/find_medicament_by_code.xqy");

    public String getAllReviews() {
        try {
            XMLResource resource = getResource(collectionId, documentId);

            System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");


            //Lekovi lekovi = (Lekovi) super.unmarshaller.unmarshal(resource.getContentAsDOM());

            //return lekovi;

            return (String) resource.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveAll() throws Exception {
        JAXBContext context = JAXBContext.newInstance("com.svj.zis.model");
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //Lekovi lekovi = (Lekovi) super.unmarshaller.unmarshal(lekoviXml.getFile());
        Lekovi lekovi = (Lekovi) unmarshaller.unmarshal(lekoviXml.getFile());
        super.saveAll(collectionId, documentId, lekovi);
    }

    public String getMedicament(String id) throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String path = findMedicamentByIdXQuery.getFile().getPath();
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

    public Lek getMedicamentByCode(String code) throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String path = findMedicamentByCodeXQuery.getFile().getPath();
        String contentStr = loadFileContent(path);
        String sadrzajUpita = String.format(contentStr, code);
        CompiledExpression compiledExpression = xQueryService.compile(sadrzajUpita);
        ResourceSet resourceSet = xQueryService.execute(compiledExpression);
        ResourceIterator i = resourceSet.getIterator();

        JAXBContext context = JAXBContext.newInstance("com.svj.zis.model");
        Unmarshaller unmarshaller = context.createUnmarshaller();

        org.xmldb.api.base.Resource resource = null;
        if(i.hasMoreResources()) {

            try {
                resource = i.nextResource();
                XMLResource xmlResource = (XMLResource) resource;
                System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");

                Lek lek = (Lek) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
                return lek;
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
