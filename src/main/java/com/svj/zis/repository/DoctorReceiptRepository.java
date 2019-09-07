package com.svj.zis.repository;

import com.svj.zis.model.Lek;
import com.svj.zis.model.Lekar;
import com.svj.zis.model.LekarskiRecepti;
import com.svj.zis.model.ZdravstveniKarton;
import com.svj.zis.util.template.XUpdateTemplate;
import org.exist.xmldb.EXistResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XQueryService;
import org.xmldb.api.modules.XUpdateQueryService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.time.LocalDate;
import java.util.UUID;


@Repository
public class DoctorReceiptRepository extends ResourceRepository {

    private String collectionId = "/db/zis/lekarski_recepti";
    private String documentId = "lekarski_recepti.xml";
    private ClassPathResource lekarskiReceptiXml = new ClassPathResource("xml/" + documentId);
    private ClassPathResource findMedicalRecipesByNumberOfHeathCardXQuery = new ClassPathResource("xqueries/find_medical_recipes_by_number_of_heath_card.xqy");
    private ClassPathResource findMedicalRecipeByIdXQuery = new ClassPathResource("xqueries/find_medical_recipe_by_id.xqy");
    private ClassPathResource findDoctorReceiptsLengthXQuery = new ClassPathResource("xqueries/find_doctor_receipts_length.xqy");

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

    public LekarskiRecepti getDoctorReceipts() {
        try {
            XMLResource resource = getResource(collectionId, documentId);

            System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");

            JAXBContext context = JAXBContext.newInstance("com.svj.zis.model");
            Unmarshaller unmarshaller = context.createUnmarshaller();

            LekarskiRecepti lekarskiRecepti = (LekarskiRecepti) unmarshaller.unmarshal(resource.getContentAsDOM());

            return lekarskiRecepti;

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

    public String getDoctorReceipt(String id) throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String path = findMedicalRecipeByIdXQuery.getFile().getPath();
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

    public int getDoctorReceiptsLength() throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String path = findDoctorReceiptsLengthXQuery.getFile().getPath();
        String sadrzajUpita = loadFileContent(path);
        CompiledExpression compiledExpression = xQueryService.compile(sadrzajUpita);
        ResourceSet resourceSet = xQueryService.execute(compiledExpression);
        ResourceIterator i = resourceSet.getIterator();

        org.xmldb.api.base.Resource resource = null;
        if(i.hasMoreResources()) {

            try {
                resource = i.nextResource();
                return Integer.parseInt((String) resource.getContent());
            } finally {

                // don't forget to cleanup resources
                try {
                    ((EXistResource)resource).freeResources();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }

        return -10000;
    }

    public void makeDoctorReceipt(Lekar lekar, ZdravstveniKarton zdravstveniKarton, Lek lek,
                                  String nazivZdrastveneUstanove, String drzava, String potpisLekara,
                                  String dijagnoza, int redniBroj, int kolicina, String rp) throws Exception {
        String newDoctorReceiptIdNum = "" + (getDoctorReceiptsLength() + 1);
        LocalDate datum = LocalDate.now();

        String monthStr = "" + datum.getMonthValue();
        if(monthStr.length() == 1) {
            monthStr = "0" + monthStr;
        }

        String dayStr = "" + datum.getDayOfMonth();
        if(dayStr.length() == 1) {
            dayStr = "0" + dayStr;
        }

        Collection collection = getCollection(collectionId);

        // get an instance of xupdate query service
        System.out.println("[INFO] Fetching XUpdate service for the collection.");
        XUpdateQueryService xupdateService = (XUpdateQueryService) collection.getService("XUpdateQueryService", "1.0");
        xupdateService.setProperty("indent", "yes");

        // update patient's content
        String contextXPathElement = "/lekarski_recepti";

        // compile and execute xupdate expressions
        System.out.println("[INFO] Updating " + contextXPathElement + " node.");
        String targetNamespace = "http://www.svj.com/zis/kolekcije";
        String xmlFragment = "<dokumenti:lekarski_recept id=\"http://www.svj.com/zis/dokumenti/lekarski_recept/"+newDoctorReceiptIdNum+"\" about=\"http://www.svj.com/zis/dokumenti/lekarski_recept/"+newDoctorReceiptIdNum+"\">" +
                                "<dokumenti:osigurano_lice>" +
                                    "<dokumenti:ime>"+zdravstveniKarton.getPacijentoviPodaci().getIme()+"</dokumenti:ime>" +
                                    "<dokumenti:prezime>"+zdravstveniKarton.getPacijentoviPodaci().getPrezime()+"</dokumenti:prezime>" +
                                    "<dokumenti:datum_rodjenja>"+zdravstveniKarton.getPacijentoviPodaci().getDatumRodjenja().toXMLFormat()+"</dokumenti:datum_rodjenja>" +
                                    "<dokumenti:pacijent id=\""+zdravstveniKarton.getPacijentoviPodaci().getPacijent().getId()+"\" href=\""+zdravstveniKarton.getPacijentoviPodaci().getPacijent().getId()+"\" rel=\"pred:osiguranoLice\"/>" +
                                "</dokumenti:osigurano_lice>" +
                                "<dokumenti:ustanova>" +
                                    "<dokumenti:naziv_zdrastvene_ustanove>"+nazivZdrastveneUstanove+"</dokumenti:naziv_zdrastvene_ustanove>" +
                                    "<dokumenti:drzava>"+drzava+"</dokumenti:drzava>" +
                                "</dokumenti:ustanova>" +
                                "<dokumenti:zdravstveni_karton id=\""+zdravstveniKarton.getId()+"\" broj_zdravstvenog_kartona=\""+zdravstveniKarton.getBrojKartona()+"\" broj_zdrastvene_knjizice=\""+zdravstveniKarton.getBrojZdrastveneKnjizice()+"\" href=\""+zdravstveniKarton.getId()+"\" rel=\"pred:zdravstveniKarton\"/>" +
                                "<dokumenti:osnov_oslobadjanja_od_participacije>"+zdravstveniKarton.getPacijentoviPodaci().getOsnovOslobadjanjaOdParticipacije()+"</dokumenti:osnov_oslobadjanja_od_participacije>" +
                                "<dokumenti:podaci_o_lekaru>" +
                                    "<dokumenti:ime>"+lekar.getIme()+"</dokumenti:ime>" +
                                    "<dokumenti:prezime>"+lekar.getPrezime()+"</dokumenti:prezime>" +
                                    "<dokumenti:potpis_lekara>"+potpisLekara+"</dokumenti:potpis_lekara>" +
                                    "<dokumenti:lekar id=\""+lekar.getId()+"\" href=\""+lekar.getId()+"\" rel=\"pred:lekar\"/>" +
                                "</dokumenti:podaci_o_lekaru>" +
                                "<dokumenti:propisani_lek>" +
                                    "<dokumenti:naziv>"+lek.getNaziv()+"</dokumenti:naziv>" +
                                    "<dokumenti:sifra>"+lek.getSifra()+"</dokumenti:sifra>" +
                                    "<dokumenti:datum>"+datum.getYear()+"-"+monthStr+"-"+dayStr+"</dokumenti:datum>" +
                                    "<dokumenti:lek id=\""+lek.getId()+"\"  href=\""+lek.getId()+"\" rel=\"pred:lek\"/>" +
                                "</dokumenti:propisani_lek>" +
                                "<dokumenti:izdati_lek>" +
                                    "<dokumenti:naziv></dokumenti:naziv>" +
                                    "<dokumenti:sifra></dokumenti:sifra>" +
                                    "<dokumenti:datum></dokumenti:datum>" +
                                    "<dokumenti:lek id=\"\" />" +
                                "</dokumenti:izdati_lek>" +
                                "<dokumenti:dijagnoza>"+dijagnoza+"</dokumenti:dijagnoza>" +
                                "<dokumenti:redni_broj>"+redniBroj+"</dokumenti:redni_broj>" +
                                "<dokumenti:kolicina>"+kolicina+"</dokumenti:kolicina>" +
                                "<dokumenti:potpis_farmaceuta></dokumenti:potpis_farmaceuta>" +
                                "<dokumenti:lek_primio></dokumenti:lek_primio>" +
                                "<dokumenti:rp>"+rp+"</dokumenti:rp>" +
                            "</dokumenti:lekarski_recept>";
        String xUpdateExpression = String.format(XUpdateTemplate.APPEND, targetNamespace,
                "xmlns:dokumenti=\"http://www.svj.com/zis/dokumenti\"", contextXPathElement, xmlFragment);
        System.out.println("*** xUpdateExpression:");
        System.out.println(xUpdateExpression);
        long mods = xupdateService.updateResource(documentId, xUpdateExpression);
        System.out.println("[INFO] " + mods + " modifications processed.");
    }
}
