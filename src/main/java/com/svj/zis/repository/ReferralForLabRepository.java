package com.svj.zis.repository;

import com.svj.zis.model.Lekar;
import com.svj.zis.model.UputiZaLaboratoriju;
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
import java.util.Random;


@Repository
public class ReferralForLabRepository extends ResourceRepository {

    private String collectionId = "/db/zis/uputi_za_laboratoriju";
    private String documentId = "uputi_za_laboratoriju.xml";
    private ClassPathResource uputiZaLaboratorijuXml = new ClassPathResource("xml/" + documentId);
    private ClassPathResource findReferralsForLabByPatientIdXQuery = new ClassPathResource("xqueries/find_referrals_for_lab_by_number_of_heath_card.xqy");
    private ClassPathResource findReferralForLabByIdXQuery = new ClassPathResource("xqueries/find_referral_for_lab_by_id.xqy");
    private ClassPathResource findReferralsForLabLengthXQuery = new ClassPathResource("xqueries/find_referrals_for_lab_length.xqy");


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
        JAXBContext context = JAXBContext.newInstance("com.svj.zis.model");
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //UputiZaLaboratoriju uputiZaLaboratoriju = (UputiZaLaboratoriju) super.unmarshaller.unmarshal(uputiZaLaboratorijuXml.getFile());
        UputiZaLaboratoriju uputiZaLaboratoriju = (UputiZaLaboratoriju) unmarshaller.unmarshal(uputiZaLaboratorijuXml.getFile());
        super.saveAll(collectionId, documentId, uputiZaLaboratoriju);
    }

    private int getReferralsForLabLength() throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String path = findReferralsForLabLengthXQuery.getFile().getPath();
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

    public String getReferralForLab(String id) throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String path = findReferralForLabByIdXQuery.getFile().getPath();
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

    public void makeReferralForLab(Lekar lekar, ZdravstveniKarton zdravstveniKarton,
                                   String zdravstvenaUstanovaKojaSalje, String zdravstvenaUstanovaKojaPrima,
                                   String kadJeUzetMaterijal, String klinickaDijagnoza, String tipPregleda, String potpisLekara,
                                   String pecat) throws Exception {
        String newReferralForLabIdNum = "" + (getReferralsForLabLength() + 1);
        String newReferralForLabId = "http://www.svj.com/zis/dokumenti/uput_za_laboratoriju/"+newReferralForLabIdNum;

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
        String contextXPathElement = "/uputi_za_laboratoriju";

        // compile and execute xupdate expressions
        System.out.println("[INFO] Updating " + contextXPathElement + " node.");
        String targetNamespace = "http://www.svj.com/zis/kolekcije";
        String xmlFragment = "<dokumenti:uput_za_laboratoriju id=\""+newReferralForLabId+"\" " +
                "reg_br=\""+getRandomRegBr()+"\" about=\""+newReferralForLabId+"\">" +
                "<dokumenti:zdravstvena_ustanova_koja_salje datatype=\"xs:string\" property=\"pred:ustanova\">"+zdravstvenaUstanovaKojaSalje+"</dokumenti:zdravstvena_ustanova_koja_salje>" +
                "<dokumenti:zdravstvena_ustanova_koja_prima datatype=\"xs:string\" property=\"pred:ustanova\">"+zdravstvenaUstanovaKojaPrima+"</dokumenti:zdravstvena_ustanova_koja_prima>" +
                "<dokumenti:zdravstveni_karton id=\""+zdravstveniKarton.getId()+"\" broj_zdravstvenog_kartona=\""+zdravstveniKarton.getBrojKartona()+"\" broj_zdrastvene_knjizice=\""+zdravstveniKarton.getBrojZdrastveneKnjizice()+"\" href=\""+zdravstveniKarton.getId()+"\" rel=\"pred:zdravstveniKarton\"/>" +
                "<dokumenti:podaci_o_osiguranju>" +
                "<dokumenti:nosilac_osiguranja>" +
                "<dokumenti:ime datatype=\"xs:string\" property=\"pred:ime\">"+zdravstveniKarton.getPacijentoviPodaci().getIme()+"</dokumenti:ime>" +
                "<dokumenti:prezime datatype=\"xs:string\" property=\"pred:prezime\">"+zdravstveniKarton.getPacijentoviPodaci().getPrezime()+"</dokumenti:prezime>" +
                "<dokumenti:pacijent id=\""+zdravstveniKarton.getPacijentoviPodaci().getPacijent().getId()+"\"/>" +
                "</dokumenti:nosilac_osiguranja>" +
                "<dokumenti:osnov_osiguranja>zaposlen</dokumenti:osnov_osiguranja>" +
                "</dokumenti:podaci_o_osiguranju>" +
                "<dokumenti:klinicka_dijagnoza>"+klinickaDijagnoza+"</dokumenti:klinicka_dijagnoza>" +
                "<dokumenti:kad_je_uzet_materijal datatype=\"xs:dateTime\" property=\"pred:datumIVreme\">"+kadJeUzetMaterijal+"</dokumenti:kad_je_uzet_materijal>" +
                "<dokumenti:ko_salje_materijal>" +
                "<dokumenti:ime datatype=\"xs:string\" property=\"pred:ime\">"+zdravstveniKarton.getPacijentoviPodaci().getIme()+"</dokumenti:ime>" +
                "<dokumenti:prezime datatype=\"xs:string\" property=\"pred:prezime\">"+zdravstveniKarton.getPacijentoviPodaci().getPrezime()+"</dokumenti:prezime>" +
                "<dokumenti:pacijent id=\""+zdravstveniKarton.getPacijentoviPodaci().getPacijent().getId()+"\"/>" +
                "</dokumenti:ko_salje_materijal>" +
                "<dokumenti:ko_salje_na_pregled>" +
                "<dokumenti:ime datatype=\"xs:string\" property=\"pred:ime\">"+lekar.getIme()+"</dokumenti:ime>" +
                "<dokumenti:prezime datatype=\"xs:string\" property=\"pred:prezime\">"+lekar.getPrezime()+"</dokumenti:prezime>" +
                "<dokumenti:potpis_lekara>"+potpisLekara+"</dokumenti:potpis_lekara>" +
                "<dokumenti:lekar id=\""+lekar.getId()+"\"/>" +
                "</dokumenti:ko_salje_na_pregled>" +
                "<dokumenti:tip_pregleda>"+tipPregleda+"</dokumenti:tip_pregleda>" +
                "<dokumenti:pecat>"+pecat+"</dokumenti:pecat>" +
                "<dokumenti:datum>"+datum.getYear()+"-"+monthStr+"-"+dayStr+"</dokumenti:datum>" +
                "</dokumenti:uput_za_laboratoriju>";
        String xUpdateExpression = String.format(XUpdateTemplate.APPEND, targetNamespace,
                "xmlns:dokumenti=\"http://www.svj.com/zis/dokumenti\"", contextXPathElement, xmlFragment);
        System.out.println("*** xUpdateExpression:");
        System.out.println(xUpdateExpression);
        long mods = xupdateService.updateResource(documentId, xUpdateExpression);
        System.out.println("[INFO] " + mods + " modifications processed.");
    }

    private String getRandomRegBr() {
        Random random = new Random();
        String regBr = "";
        for(int i = 0; i < 10; i++) {
            regBr += Math.round(random.nextDouble()*10);
        }

        return regBr;
    }
}