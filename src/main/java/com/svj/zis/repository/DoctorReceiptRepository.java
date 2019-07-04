package com.svj.zis.repository;

import com.svj.zis.model.LekarskiRecepti;
import org.exist.xmldb.EXistResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XQueryService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;


@Repository
public class DoctorReceiptRepository extends ResourceRepository {

    private String collectionId = "/db/zis/lekarski_recepti";
    private String documentId = "lekarski_recepti.xml";
    private ClassPathResource lekarskiReceptiXml = new ClassPathResource("xml/" + documentId);
    private ClassPathResource findMedicalRecipesByNumberOfHeathCardXQuery = new ClassPathResource("xqueries/find_medical recipes_by_number_of_heath_card.xqy");

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
        JAXBContext context = JAXBContext.newInstance("com.svj.zis.model");
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //LekarskiRecepti lekarskiRecepti = (LekarskiRecepti) super.unmarshaller.unmarshal(lekarskiReceptiXml.getFile());
        LekarskiRecepti lekarskiRecepti = (LekarskiRecepti) unmarshaller.unmarshal(lekarskiReceptiXml.getFile());
        super.saveAll(collectionId, documentId, lekarskiRecepti);
    }

    public String getDoctorRecipes(String numberOfHeathCard) throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String path = findMedicalRecipesByNumberOfHeathCardXQuery.getFile().getPath();
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
