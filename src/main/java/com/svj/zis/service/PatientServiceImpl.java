package com.svj.zis.service;

import com.svj.zis.model.Pacijent;
import com.svj.zis.model.ZdravstveniKarton;
import com.svj.zis.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;
import java.io.IOException;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private TransformationService transformationService;

    @Autowired
    private HealthCardService healthCardService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private ReferralForSpecialistExaminationService referralForSpecialistExaminationService;

    @Autowired
    private ReferralForLabService referralForLabService;

    @Autowired
    private DoctorReceiptService doctorReceiptService;


    private ClassPathResource lekariXsl = new ClassPathResource("xsl/lekari.xsl");
    private ClassPathResource lekarXsl = new ClassPathResource("xsl/lekar.xsl");
    private ClassPathResource preglediXsl = new ClassPathResource("xsl/pregledi.xsl");
    private ClassPathResource zdravstveniKartonXsl = new ClassPathResource("xsl/zdravstveni_karton.xsl");
    private ClassPathResource izvestajiXsl = new ClassPathResource("xsl/izvestaji.xsl");
    private ClassPathResource uputiZaSpecijalistickiPregledXsl = new ClassPathResource("xsl/uputi_za_specijalisticki_pregled.xsl");
    private ClassPathResource uputiZaLaboratorijuXsl = new ClassPathResource("xsl/uputi_za_laboratoriju.xsl");
    private ClassPathResource lekarskiReceptiXsl = new ClassPathResource("xsl/lekarski_recepti.xsl");


    @Override
    public String getAllDoctors() {
        //String processInstruction = "<?xml-stylesheet type=\"text/xsl\" href=\"src/main/resources/xsl/lekari.xsl\"?>\n";
        String doctorsXml = doctorService.getAllDoctors();
        //doctorsXml = processInstruction + doctorsXml;
        String xHTML = null;
        try {
            xHTML = transformationService.generateHTML(doctorsXml, lekariXsl.getFile());
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?", "");
        return xHTML;
    }

    @Override
    public String getDoctor(String idOfPatient) throws Exception {
        Pacijent pacijent = patientRepository.findById(idOfPatient);
        ZdravstveniKarton zdravstveniKarton = healthCardService.getHealthCard(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona());
        String doctorXml = doctorService.getDoctor(zdravstveniKarton.getOdabraniLekar().getId());

        String xHTML = null;
        try {
            xHTML = transformationService.generateHTML(doctorXml, lekarXsl.getFile());
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?", "");
        return xHTML;
    }

    @Override
    public void selectDoctor(String idOfPatient, String idOfDoctor) throws Exception {
        Pacijent pacijent = patientRepository.findById(idOfPatient);
        healthCardService.updateChosenDoctor(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona(), idOfDoctor);
    }

    @Override
    public String getFreeReviews(String idOfPatient) throws Exception {
        Pacijent pacijent = patientRepository.findById(idOfPatient);
        ZdravstveniKarton zdravstveniKarton = healthCardService.getHealthCard(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona());
        String preglediXml = reviewService.getFreeReviews(zdravstveniKarton.getOdabraniLekar().getId());

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
    public String getOrderedReviews(String idOfPatient) throws Exception {
        String preglediXml = reviewService.getOrderedReviews(idOfPatient);

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
    public void orederReview(String idOfPatient, String idOfReview) throws Exception {
        reviewService.updateReview(idOfPatient, idOfReview);
    }

    @Override
    public String getHealthCard(String idOfPatient) throws Exception {
        Pacijent pacijent = patientRepository.findById(idOfPatient);
        String zdravstveniKartonXml = healthCardService.getHealthCardXml(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona());

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
    public String getAllReports(String idOfPatient) throws Exception {
        String izvestajiXml = reportService.getReports(idOfPatient);

        String xHTML = null;
        try {
            xHTML = transformationService.generateHTML(izvestajiXml, izvestajiXsl.getFile());
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?", "");
        return xHTML;
    }

    @Override
    public String getReferralsForSpecialistExamination(String idOfPatient) throws Exception {
        Pacijent pacijent = patientRepository.findById(idOfPatient);
        String uputiZaSpecijalistickiPregledXml = referralForSpecialistExaminationService.getReferralsForSpecialistExamination(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona());

        String xHTML = null;
        try {
            xHTML = transformationService.generateHTML(uputiZaSpecijalistickiPregledXml, uputiZaSpecijalistickiPregledXsl.getFile());
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?", "");
        return xHTML;
    }

    @Override
    public String getReferralsForLab(String idOfPatient) throws Exception {
        Pacijent pacijent = patientRepository.findById(idOfPatient);
        String uputiZaLaboratorijuXml = referralForLabService.getReferralsForLab(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona());

        String xHTML = null;
        try {
            xHTML = transformationService.generateHTML(uputiZaLaboratorijuXml, uputiZaLaboratorijuXsl.getFile());
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?", "");
        return xHTML;
    }

    @Override
    public String getDoctorRecipes(String idOfPatient) throws Exception {
        Pacijent pacijent = patientRepository.findById(idOfPatient);
        String lekarskiReceptiXml = doctorReceiptService.getDoctorRecipes(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona());

        String xHTML = null;
        try {
            xHTML = transformationService.generateHTML(lekarskiReceptiXml, lekarskiReceptiXsl.getFile());
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?", "");
        return xHTML;
    }

}
