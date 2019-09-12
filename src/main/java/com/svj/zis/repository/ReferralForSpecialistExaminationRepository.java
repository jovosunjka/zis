package com.svj.zis.repository;

import com.svj.zis.model.Lekar;
import com.svj.zis.model.UputiZaSpecijalistickiPregled;
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
import java.util.UUID;


@Repository
public class ReferralForSpecialistExaminationRepository extends ResourceRepository {

    private String collectionId = "/db/zis/uputi_za_specijalisticki_pregled";
    private String documentId = "uputi_za_specijalisticki_pregled.xml";
    private ClassPathResource uputiZaSpecijalistickiPregledXml = new ClassPathResource("xml/" + documentId);
    private ClassPathResource findReferralsForSpecialistExaminationByPatientIdXQuery = new ClassPathResource("xqueries/find_referrals_for_specialist_examination_by_number_of_heath_card.xqy");
    private ClassPathResource findReferralForSpecialistExaminationByIdXQuery = new ClassPathResource("xqueries/find_referral_for_specialist_examination_by_id.xqy");
    private ClassPathResource findReferralsForSpecialistExaminationLengthXQuery = new ClassPathResource("xqueries/find_referrals_for_specialist_examination_length.xqy");


    public String getAllReferralsForSpecialistExamination() {
        try {
            XMLResource resource = getResource(collectionId, documentId);

            System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");


            //UputiZaSpecijalistickiPregled uputiZaSpecijalistickiPregled = (UputiZaSpecijalistickiPregled) super.unmarshaller.unmarshal(resource.getContentAsDOM());

            //return uputiZaSpecijalistickiPregled;

            return (String) resource.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveAll() throws Exception {
        JAXBContext context = JAXBContext.newInstance("com.svj.zis.model");
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //UputiZaSpecijalistickiPregled uputiZaSpecijalistickiPregled = (UputiZaSpecijalistickiPregled) super.unmarshaller.unmarshal(uputiZaSpecijalistickiPregledXml.getFile());
        UputiZaSpecijalistickiPregled uputiZaSpecijalistickiPregled = (UputiZaSpecijalistickiPregled) unmarshaller.unmarshal(uputiZaSpecijalistickiPregledXml.getFile());
        super.saveAll(collectionId, documentId, uputiZaSpecijalistickiPregled);
    }

    public String getReferralsForSpecialistExamination(String numberOfHeathCard) throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String path = findReferralsForSpecialistExaminationByPatientIdXQuery.getFile().getPath();
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

    private int getReferralForSpecExaminationsLength() throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String path = findReferralsForSpecialistExaminationLengthXQuery.getFile().getPath();
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

    public String getReferralForSpecialistExamination(String id) throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String path = findReferralForSpecialistExaminationByIdXQuery.getFile().getPath();
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

    public void makeReferralForSpecExamination(Lekar lekar, ZdravstveniKarton zdravstveniKarton,
                                               String zdravstvenaUstanovaKojaSalje, String zdravstvenaUstanovaKojaPrima,
                                               Lekar specijalista, String potpisLekara, String pecat) throws Exception {
        String newReferralForSpecExaminationIdNum = "" + (getReferralForSpecExaminationsLength() + 1);
        String newReferralForSpecExaminationId = "http://www.svj.com/zis/dokumenti/uput_za_specijalisticki_pregled/"+newReferralForSpecExaminationIdNum;

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
        String contextXPathElement = "/uputi_za_specijalisticki_pregled";

        // compile and execute xupdate expressions
        System.out.println("[INFO] Updating " + contextXPathElement + " node.");
        String targetNamespace = "http://www.svj.com/zis/kolekcije";
        String xmlFragment = "<dokumenti:uput_za_specijalisticki_pregled id=\""+newReferralForSpecExaminationId+"\" " +
                "reg_br=\""+getRandomRegBr()+"\" about=\""+newReferralForSpecExaminationId+"\">" +
                "<dokumenti:zdravstvena_ustanova_koja_salje datatype=\"xs:string\" property=\"pred:ustanova\">"+zdravstvenaUstanovaKojaSalje+"</dokumenti:zdravstvena_ustanova_koja_salje>" +
                "<dokumenti:zdravstvena_ustanova_koja_prima datatype=\"xs:string\" property=\"pred:ustanova\">"+zdravstvenaUstanovaKojaPrima+"</dokumenti:zdravstvena_ustanova_koja_prima>" +
                "<dokumenti:zdravstveni_karton id=\""+zdravstveniKarton.getId()+"\" broj_zdravstvenog_kartona=\""+zdravstveniKarton.getBrojKartona()+"\" broj_zdrastvene_knjizice=\""+zdravstveniKarton.getBrojZdrastveneKnjizice()+"\" href=\""+zdravstveniKarton.getId()+"\" rel=\"pred:zdravstveniKarton\"/>" +
                "<dokumenti:lekar id=\""+lekar.getId()+"\">" +
                "<dokumenti:ime datatype=\"xs:string\" property=\"pred:ime\">"+lekar.getIme()+"</dokumenti:ime>" +
                "<dokumenti:prezime datatype=\"xs:string\" property=\"pred:prezime\">"+lekar.getPrezime()+"</dokumenti:prezime>" +
                "<dokumenti:potpis_lekara>"+potpisLekara+"</dokumenti:potpis_lekara>" +
                "<dokumenti:pecat>"+pecat+"</dokumenti:pecat>" +
                "</dokumenti:lekar>" +
                "<dokumenti:datum>"+datum.getYear()+"-"+monthStr+"-"+dayStr+"</dokumenti:datum>" +
                "<dokumenti:podaci_o_osiguranju>" +
                "<dokumenti:nosilac_osiguranja>" +
                "<dokumenti:ime datatype=\"xs:string\" property=\"pred:ime\">"+zdravstveniKarton.getPacijentoviPodaci().getIme()+"</dokumenti:ime>" +
                "<dokumenti:prezime datatype=\"xs:string\" property=\"pred:prezime\">"+zdravstveniKarton.getPacijentoviPodaci().getPrezime()+"</dokumenti:prezime>" +
                "<dokumenti:pacijent id=\""+zdravstveniKarton.getPacijentoviPodaci().getPacijent().getId()+"\"/>" +
                "</dokumenti:nosilac_osiguranja>" +
                "<dokumenti:osnov_osiguranja>zaposlen</dokumenti:osnov_osiguranja>" +
                "</dokumenti:podaci_o_osiguranju>" +
                "<dokumenti:specijalista>" +
                "<dokumenti:ime datatype=\"xs:string\" property=\"pred:ime\">"+specijalista.getIme()+"</dokumenti:ime>" +
                "<dokumenti:prezime datatype=\"xs:string\" property=\"pred:prezime\">"+specijalista.getPrezime()+"</dokumenti:prezime>" +
                "<dokumenti:lekar id=\""+specijalista.getId()+"\"/>" +
                "<dokumenti:lekar_specijalista_za>"+specijalista.getOblastZastite().getValue().value()+"</dokumenti:lekar_specijalista_za>" +
                "</dokumenti:specijalista>" +
                "<dokumenti:podaci_o_pregledu>" +
                "<dokumenti:svrha_pregleda></dokumenti:svrha_pregleda>" +
                "<dokumenti:obavljen_u_zdravstvenoj_ustanovi>"+zdravstvenaUstanovaKojaPrima+"</dokumenti:obavljen_u_zdravstvenoj_ustanovi>" +
                "<dokumenti:datum_i_vreme_prijave></dokumenti:datum_i_vreme_prijave>" +
                "<dokumenti:datum_i_vreme_zavrsetka></dokumenti:datum_i_vreme_zavrsetka>" +
                "</dokumenti:podaci_o_pregledu>" +
                "<dokumenti:izvestaj>" +
                "<dokumenti:osiguranik>" +
                "<dokumenti:ime datatype=\"xs:string\" property=\"pred:ime\">"+zdravstveniKarton.getPacijentoviPodaci().getIme()+"</dokumenti:ime>" +
                "<dokumenti:prezime datatype=\"xs:string\" property=\"pred:prezime\">"+zdravstveniKarton.getPacijentoviPodaci().getPrezime()+"</dokumenti:prezime>" +
                "<dokumenti:pacijent id=\""+zdravstveniKarton.getPacijentoviPodaci().getPacijent().getId()+"\"/>" +
                "</dokumenti:osiguranik>" +
                "<dokumenti:boluje_od></dokumenti:boluje_od>" +
                "<dokumenti:nalaz></dokumenti:nalaz>" +
                "<dokumenti:misljenje></dokumenti:misljenje>" +
                "<dokumenti:datum></dokumenti:datum>" +
                "<dokumenti:potpis_lekara></dokumenti:potpis_lekara>" +
                "<dokumenti:pecat></dokumenti:pecat>" +
                "</dokumenti:izvestaj>" +
                "</dokumenti:uput_za_specijalisticki_pregled>";
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
