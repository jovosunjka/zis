package com.svj.zis.service;

import com.svj.zis.dto.ReportDto;
import com.svj.zis.model.*;
import com.svj.zis.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private TransformationService transformationService;

    @Autowired
    private HealthCardService healthCardService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorReceiptService doctorReceiptService;

    @Autowired
    private  MedicamentService medicamentService;

    @Autowired
    private  ReferralForLabService referralForLabService;

    @Autowired
    private  ReferralForSpecialistExaminationService referralForSpecialistExaminationService;


    private ClassPathResource preglediXsl = new ClassPathResource("xsl/xsl_for_doctor_page/pregledi.xsl");
    private ClassPathResource zdravstveniKartoniXsl = new ClassPathResource("xsl/xsl_for_doctor_page/zdravstveni_kartoni.xsl");
    private ClassPathResource zdravstveniKartonXsl = new ClassPathResource("xsl/xsl_for_doctor_page/zdravstveni_karton.xsl");
    private ClassPathResource izvestajXsl = new ClassPathResource("xsl/xsl_for_patient_page/izvestaj.xsl");
    private ClassPathResource lekoviXsl = new ClassPathResource("xsl/xsl_for_doctor_page/lekovi.xsl");
    private ClassPathResource specijalistiXsl = new ClassPathResource("xsl/xsl_for_doctor_page/specijalisti.xsl");


    @Override
    public String getDoctor(String id) throws Exception {
        return doctorRepository.findByDoctorId(id);
    }

    @Override
    public Lekar findDoctor(String id) throws Exception {
        return doctorRepository.findDoctorByDoctorId(id);
    }

    @Override
    public String getAllDoctors() {
        return doctorRepository.getAllDoctors();
    }

    @Override
    public String getNotOverburdenedDoctors() throws Exception {
        return doctorRepository.getNotOverburdenedDoctors();
    }

    @Override
    public String getOrderedReviews(String idOfUser) throws Exception {
        Lekar lekar = doctorRepository.findByUserId(idOfUser);
        String preglediXml = reviewService.getOrderedReviewsByDoctorId(lekar.getId());

        String xHTML = null;
        try {
            xHTML = transformationService.generateHTML(preglediXml, preglediXsl.getFile());
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?", "");
        return xHTML;
    }

    @Override
    public String getReviews(String idOfDoctor, File xslFile) throws Exception {
        String preglediXml = reviewService.getReviewsByDoctorId(idOfDoctor);

        String xHTML = null;
        try {
            if (xslFile == null) {
                xslFile = preglediXsl.getFile();
            }
            xHTML = transformationService.generateHTML(preglediXml, xslFile);
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?", "");
        return xHTML;
    }

    @Override
    public String getPatients(String idOfUser) throws Exception {
        Lekar lekar = doctorRepository.findByUserId(idOfUser);
        String zdravstveniKartoniXml = healthCardService.getHealthCards(lekar.getId());

        String xHTML = null;
        try {
            xHTML = transformationService.generateHTML(zdravstveniKartoniXml, zdravstveniKartoniXsl.getFile());
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?", "");
        return xHTML;
    }

    @Override
    public String getBasicInformations(String numberOfHealthCard) throws Exception {
        String zdravstveniKartonXml = healthCardService.getHealthCardXml(numberOfHealthCard);

        String xHTML = null;
        try {
            xHTML = transformationService.generateHTML(zdravstveniKartonXml, zdravstveniKartonXsl.getFile());
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?", "");
        return xHTML;
    }

    @Override
    public void editPatientBasicInformations(String numberOfHealthCard, String jmbg, String lbo, String ime, String prezime, String imeJednogRoditelja, XMLGregorianCalendar datumRodjenja, String ulica, int broj, String mesto, String opstina, String telefon, String our, String pol, String bracnoStanje, String osnovOslobadjanjaOdParticipacije) throws Exception {
        healthCardService.editPatientBasicInformations(numberOfHealthCard, jmbg, lbo, ime, prezime, imeJednogRoditelja, datumRodjenja, ulica, broj, mesto, opstina, telefon, our, pol, bracnoStanje, osnovOslobadjanjaOdParticipacije);
    }

    @Override
    public String getPatientsBasicSearch(String idOfUser, String text) throws Exception {
        Lekar lekar = doctorRepository.findByUserId(idOfUser);
        String zdravstveniKartoniXml = healthCardService.getHealthCardsBasicSearch(lekar.getId(), text);

        String xHTML = null;
        try {
            xHTML = transformationService.generateHTML(zdravstveniKartoniXml, zdravstveniKartoniXsl.getFile());
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?", "");
        return xHTML;
    }

    @Override
    public String makeReport(String idOfUser, String idOfPatient, String dijagnoza, String anamneza,String terapija) throws Exception {
        Lekar lekar = doctorRepository.findByUserId(idOfUser);
        Pacijent pacijent = patientService.getPatientByPatientId(idOfPatient);
        ZdravstveniKarton zdravstveniKarton = healthCardService.getHealthCard(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona());
        return reportService.makeReport(lekar, zdravstveniKarton, dijagnoza, anamneza, terapija);
    }

    @Override
    public void makeDoctorReceipt(String idOfUser, String idOfPatient, String nazivZdrastveneUstanove, String drzava, String potpisLekara, String naziv, long sifra, String dijagnoza, int redniBroj, int kolicina, String rp) throws Exception {
        Lekar lekar = doctorRepository.findByUserId(idOfUser);
        Pacijent pacijent = patientService.getPatientByPatientId(idOfPatient);
        ZdravstveniKarton zdravstveniKarton = healthCardService.getHealthCard(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona());
        Lek lek = medicamentService.getMedicamentByCode("" + sifra);
        doctorReceiptService.makeDoctorReceipt(lekar, zdravstveniKarton, lek, nazivZdrastveneUstanove, drzava, potpisLekara,dijagnoza, redniBroj, kolicina, rp);
    }

    @Override
    public String getReport(String idOfReport) throws Exception {
        String izvestajXml = reportService.getReport(idOfReport);

        String xHTML = null;
        try {
            xHTML = transformationService.generateHTML(izvestajXml, izvestajXsl.getFile());
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?\"?", "");
        return xHTML;
    }

    @Override
    public String getMedicamentsByDiagnosis(String diagnosis) throws Exception {
        String lekoviXml = medicamentService.getMedicamentsByDiagnosis(diagnosis);

        String xHTML = null;
        try {
            xHTML = transformationService.generateHTML(lekoviXml, lekoviXsl.getFile());
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?\"?", "");
        return xHTML;
    }

    @Override
    public void makeReferralForLab(String idOfUser, String idOfPatient, String zdravstvenaUstanovaKojaSalje,
                                   String zdravstvenaUstanovaKojaPrima, String kadJeUzetMaterijal, String klinickaDijagnoza,
                                   String tipPregleda, String lekarovPotpis, String pecat) throws Exception {
        Lekar lekar = doctorRepository.findByUserId(idOfUser);
        Pacijent pacijent = patientService.getPatientByPatientId(idOfPatient);
        ZdravstveniKarton zdravstveniKarton = healthCardService.getHealthCard(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona());
        referralForLabService.makeReferralForLab(lekar, zdravstveniKarton, zdravstvenaUstanovaKojaSalje,
                zdravstvenaUstanovaKojaPrima, kadJeUzetMaterijal,  klinickaDijagnoza, tipPregleda, lekarovPotpis, pecat);
    }

    @Override
    public void makeReferralForSpecExamination(String idOfUser, String idOfPatient, String zdravstvenaUstanovaKojaSalje,
                                               String zdravstvenaUstanovaKojaPrima, String specijalistaId, String lekarovPotpis, String pecat) throws Exception {
        Lekar lekar = doctorRepository.findByUserId(idOfUser);
        Lekar specijalista = doctorRepository.findDoctorByDoctorId(specijalistaId);
        Pacijent pacijent = patientService.getPatientByPatientId(idOfPatient);
        ZdravstveniKarton zdravstveniKarton = healthCardService.getHealthCard(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona());
        referralForSpecialistExaminationService.makeReferralForSpecExamination(lekar, zdravstveniKarton, zdravstvenaUstanovaKojaSalje,
                zdravstvenaUstanovaKojaPrima, specijalista, lekarovPotpis, pecat);
    }

    @Override
    public String getSpecialists() throws Exception {
        String specijalistiXml = doctorRepository.getSpecialists();

        String xHTML = null;
        try {
            xHTML = transformationService.generateHTML(specijalistiXml, specijalistiXsl.getFile());
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?", "");
        return xHTML;
    }

}
