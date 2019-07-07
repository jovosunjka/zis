package com.svj.zis.service;

import com.svj.zis.model.Lekar;
import com.svj.zis.model.Pacijent;
import com.svj.zis.model.User;
import com.svj.zis.model.ZdravstveniKarton;
import com.svj.zis.model.rdf.SparqlVarNameAndValue;
import com.svj.zis.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private UserService userService;

    @Autowired
    private RdfService rdfService;


    private String[] logicOperators = { "and", "or", "not"};
    private String firstPartOfPatientId = "http://www.svj.com/zis/osobe/pacijent/";


    private ClassPathResource lekariXsl = new ClassPathResource("xsl/xsl_for_patient_page/lekari.xsl");
    private ClassPathResource lekarXsl = new ClassPathResource("xsl/xsl_for_patient_page/lekar.xsl");
    private ClassPathResource preglediXsl = new ClassPathResource("xsl/xsl_for_patient_page/pregledi.xsl");
    private ClassPathResource zdravstveniKartonXsl = new ClassPathResource("xsl/xsl_for_patient_page/zdravstveni_karton.xsl");
    private ClassPathResource zdravstveniKartonPretragaXsl = new ClassPathResource("xsl/xsl_for_patient_page/zdravstveni_karton_pretraga.xsl");
    private ClassPathResource izvestajiXsl = new ClassPathResource("xsl/xsl_for_patient_page/izvestaji.xsl");
    private ClassPathResource uputiZaSpecijalistickiPregledXsl = new ClassPathResource("xsl/xsl_for_patient_page/uputi_za_specijalisticki_pregled.xsl");
    private ClassPathResource uputiZaLaboratorijuXsl = new ClassPathResource("xsl/xsl_for_patient_page/uputi_za_laboratoriju.xsl");
    private ClassPathResource lekarskiReceptiXsl = new ClassPathResource("xsl/xsl_for_patient_page/lekarski_recepti.xsl");


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
    public String getDoctor(String idOfUser) throws Exception {
        Pacijent pacijent = patientRepository.findByUserId(idOfUser);
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
    public void selectDoctor(String idOfUser, String idOfDoctor) throws Exception {
        Pacijent pacijent = patientRepository.findByUserId(idOfUser);
        healthCardService.updateChosenDoctor(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona(), idOfDoctor);
    }

    @Override
    public String getFreeReviews(String idOfUser) throws Exception {
        Pacijent pacijent = patientRepository.findByUserId(idOfUser);
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
    public String getOrderedReviews(String idOfUser) throws Exception {
        Pacijent pacijent = patientRepository.findByUserId(idOfUser);
        String preglediXml = reviewService.getOrderedReviews(pacijent.getId());

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
    public void orderReview(String idOfUser, String idOfReview) throws Exception {
        Pacijent pacijent = patientRepository.findByUserId(idOfUser);
        ZdravstveniKarton zdravstveniKarton = healthCardService.getHealthCard(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona());
        reviewService.updateReview(idOfReview, pacijent.getId(), zdravstveniKarton.getPacijentoviPodaci().getIme(),
                zdravstveniKarton.getPacijentoviPodaci().getPrezime());
    }

    @Override
    public Pacijent getPatientByUserId(String idOfUser) throws Exception {
        return patientRepository.findByUserId(idOfUser);
    }

    @Override
    public Pacijent getPatient(String idOfPatientNum) throws Exception {
        Pacijent pacijent =  null;
        if(idOfPatientNum == null) {
                User loggedUser = userService.getLoggedUser();
                pacijent = getPatientByUserId(loggedUser.getId());
        }
        else {
            String idOfPatient = firstPartOfPatientId + idOfPatientNum;
            pacijent = getPatientById(idOfPatient);
        }

        return pacijent;
    }

    private Pacijent getPatientById(String idOfPatient) throws Exception {
        return patientRepository.findByPatientId(idOfPatient);
    }

    @Override
    public String getHealthCard(String healthCardNumber) throws Exception {
        String zdravstveniKartonXml = healthCardService.getHealthCardXml(healthCardNumber);

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
    public String basicSearchHealthCard(String healthCardNumber, String text) throws Exception {
        String zdravstveniKartonXml = healthCardService.getHealthCardXml(healthCardNumber);

        String xHTML = null;
        try {
            String xslString;
            if(text.trim().equals("")) {
                xslString = patientRepository.loadFileContent(zdravstveniKartonXsl.getFile().getPath());
            }
            else {
                String[] args = new String[38];
                for (int i = 0; i < args.length; i++) args[i] = text;

                String zdravstveniKartonXslString = patientRepository.loadFileContent(zdravstveniKartonPretragaXsl.getFile().getPath());
                xslString = String.format(zdravstveniKartonXslString, args);
            }
            xHTML = transformationService.generateHTML(zdravstveniKartonXml, xslString);
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?", "");
        return xHTML;
    }

    @Override
    public String advancedSearchHealthCard(String healthCardNumber, String text) throws IOException {
        List<SparqlVarNameAndValue> uris = rdfService.advancedSearch(healthCardNumber, text);
        StringBuilder sb = new StringBuilder("");
        uris.stream()
                .forEach(uri -> {
                        sb.append("<a href=\"");
                        String[] tokens = uri.getValue().split("/");
                        String idNum = tokens[tokens.length-1];
                        sb.append("http://localhost:8081/api/search/");
                        sb.append(uri.getVarName());
                        sb.append("/");
                        sb.append(idNum);
                        sb.append("\">");
                        sb.append(uri.getValue());
                        sb.append("</a>");
                    sb.append("<br/>");
                    }
                );
        return sb.toString();
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
    public String getReferralsForSpecialistExamination(String healthCardNumber) throws Exception {
        String uputiZaSpecijalistickiPregledXml = referralForSpecialistExaminationService.getReferralsForSpecialistExamination(healthCardNumber);

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
    public String getReferralsForLab(String healthCardNumber) throws Exception {
        String uputiZaLaboratorijuXml = referralForLabService.getReferralsForLab(healthCardNumber);

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
    public String getDoctorRecipes(String healthCardNumber) throws Exception {
        String lekarskiReceptiXml = doctorReceiptService.getDoctorRecipes(healthCardNumber);

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
