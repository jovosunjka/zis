package com.svj.zis.repository;

import com.svj.zis.model.ZdravstveniKarton;
import com.svj.zis.model.ZdravstveniKartoni;
import com.svj.zis.util.template.XUpdateTemplate;
import org.exist.xmldb.EXistResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XQueryService;
import org.xmldb.api.modules.XUpdateQueryService;


@Repository
public class HealthCardRepository extends ResourceRepository {

    private String collectionId = "/db/zis/zdravstveni_kartoni";
    private String documentId = "zdravstveni_kartoni.xml";
    private ClassPathResource zdravstveniKartoniXml = new ClassPathResource("xml/" + documentId);
    private ClassPathResource findHealthCardByNumberOfCardXQuery = new ClassPathResource("xqueries/find_health_card_by_number_of_card.xqy");


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

    public void updateChosenDoctor(String numberOfHealthCard, String idOfDoctor) throws Exception {
        Collection collection = getCollection(collectionId);

        // get an instance of xupdate query service
        System.out.println("[INFO] Fetching XUpdate service for the collection.");
        XUpdateQueryService xupdateService = (XUpdateQueryService) collection.getService("XUpdateQueryService", "1.0");
        xupdateService.setProperty("indent", "yes");

        String contextXPath = String.format("/zdravstveni_kartoni/dokumenti:zdravstveni_karton[@broj_kartona = '%s']" +
                "/dokumenti:odabrani_lekar/@id", numberOfHealthCard);

        // compile and execute xupdate expressions
        System.out.println("[INFO] Updating " + contextXPath + " node.");
        String targetNamespace = "http://www.svj.com/zis/kolekcije";
        String xUpdateExpression = String.format(XUpdateTemplate.UPDATE, targetNamespace,
                "xmlns:dokumenti=\"http://www.svj.com/zis/dokumenti\"", contextXPath, idOfDoctor);
        System.out.println("*** xUpdateExpression:");
        System.out.println(xUpdateExpression);
        long mods = xupdateService.updateResource(documentId, xUpdateExpression);
        System.out.println("[INFO] " + mods + " modifications processed.");
    }

    public org.xmldb.api.base.Resource findResourceByNumberOfHealthCard(String numberOfHealthCard) throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String path = findHealthCardByNumberOfCardXQuery.getFile().getPath();
        String contentStr = loadFileContent(path);
        String sadrzajUpita = String.format(contentStr, numberOfHealthCard);
        CompiledExpression compiledExpression = xQueryService.compile(sadrzajUpita);
        ResourceSet resourceSet = xQueryService.execute(compiledExpression);
        ResourceIterator i = resourceSet.getIterator();

        org.xmldb.api.base.Resource resource = null;
        if(i.hasMoreResources()) {

            try {
                resource = i.nextResource();
                return resource;
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

    public ZdravstveniKarton findByNumberOfHealthCard(String numberOfHealthCard) throws Exception {
        org.xmldb.api.base.Resource resource = findResourceByNumberOfHealthCard(numberOfHealthCard);
        XMLResource xmlResource = (XMLResource) resource;
        System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");

        ZdravstveniKarton zdravstveniKarton = (ZdravstveniKarton) super.unmarshaller.unmarshal(xmlResource.getContentAsDOM());
        return zdravstveniKarton;
    }

    public String getHealthCardXml(String numberOfHealthCard) throws Exception {
        org.xmldb.api.base.Resource resource = findResourceByNumberOfHealthCard(numberOfHealthCard);
        return (String) resource.getContent();
    }
}