package com.svj.zis.service;

import com.svj.zis.model.Pacijent;
import com.svj.zis.model.User;
import com.svj.zis.model.ZdravstveniKarton;
import com.svj.zis.model.rdf.SparqlVarNameAndValue;
import com.svj.zis.repository.PatientRepository;
import io.jsonwebtoken.lang.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    private ClassPathResource lekarXsl = new ClassPathResource("xsl/xsl_for_patient_page/odabrani_lekar.xsl");
    private ClassPathResource preglediXsl = new ClassPathResource("xsl/xsl_for_patient_page/pregledi.xsl");
    private ClassPathResource izaberiPregledXsl = new ClassPathResource("xsl/xsl_for_patient_page/izaberi_pregled.xsl");
    private ClassPathResource zdravstveniKartonXsl = new ClassPathResource("xsl/xsl_for_patient_page/zdravstveni_karton.xsl");
    private ClassPathResource zdravstveniKartonPretragaXsl = new ClassPathResource("xsl/xsl_for_patient_page/zdravstveni_karton_pretraga.xsl");
    private ClassPathResource izvestajiXsl = new ClassPathResource("xsl/xsl_for_patient_page/izvestaji.xsl");
    private ClassPathResource uputiZaSpecijalistickiPregledXsl = new ClassPathResource("xsl/xsl_for_patient_page/uputi_za_specijalisticki_pregled.xsl");
    private ClassPathResource uputiZaLaboratorijuXsl = new ClassPathResource("xsl/xsl_for_patient_page/uputi_za_laboratoriju.xsl");
    private ClassPathResource lekarskiReceptiXsl = new ClassPathResource("xsl/xsl_for_patient_page/lekarski_recepti.xsl");
    private ClassPathResource obavestenjaXsl = new ClassPathResource("xsl/xsl_for_patient_page/obavestenja.xsl");


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
    public String getNotOverburdenedDoctors() throws Exception {
        //String processInstruction = "<?xml-stylesheet type=\"text/xsl\" href=\"src/main/resources/xsl/lekari.xsl\"?>\n";
        String doctorsXml = doctorService.getNotOverburdenedDoctors();
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
            xHTML = transformationService.generateHTML(preglediXml, izaberiPregledXsl.getFile());
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
    public Pacijent getPatientByPatientId(String idOfPatient) throws Exception {
        return patientRepository.findByPatientId(idOfPatient);
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
                String zdravstveniKartonXslString = patientRepository.loadFileContent(zdravstveniKartonPretragaXsl.getFile().getPath());
                xslString = String.format(zdravstveniKartonXslString, text);
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

    private List<SparqlVarNameAndValue> addOnlyNew(List<SparqlVarNameAndValue> uris, List<SparqlVarNameAndValue> newUris) {
        newUris.stream()
                .filter(newUri -> !uris.contains(newUri))
                .forEach(newUri -> uris.add(newUri));
        return uris;
    }

    private List<SparqlVarNameAndValue> intersection(List<SparqlVarNameAndValue> uris, List<SparqlVarNameAndValue> newUris) {
        return uris.stream()
                .filter(uri -> newUris.contains(uri))
                .collect(Collectors.toList());
    }

    private List<SparqlVarNameAndValue> not(List<SparqlVarNameAndValue> uris, List<SparqlVarNameAndValue> newUris) {
        return uris.stream()
                .filter(uri -> !newUris.contains(uri))
                .collect(Collectors.toList());
    }

    @Override
    public String advancedSearchHealthCard(String idOfHealthCard, String text) throws Exception {
        List<SparqlVarNameAndValue> uris = new ArrayList<SparqlVarNameAndValue>();
        List<SparqlVarNameAndValue> notUris = new ArrayList<SparqlVarNameAndValue>();
        List<SparqlVarNameAndValue> newUris;

        List<String> tokensUris = new ArrayList<String>();
        String[] tokensUris2 = text.split("\"");
        for(String token2 : tokensUris2) {
            if(token2.equals("")) continue;

            int start = text.indexOf(token2);
            int end = start + token2.length() - 1;
            if(start == 0 || end == text.length()-1 ||  text.charAt(start-1) != '"' || text.charAt(end+1) != '"') {
                tokensUris.addAll(Collections.arrayToList(token2.split("\\s+")));
                // proveravamo da li se radi o tokenu sa vise reci, tj, o tokenu koji sadrzi navodnike
            }
            else {
                tokensUris.add(token2);
            }

        }

        String operator = null;
        for(String token : tokensUris) {
            if(token.startsWith("<") && token.endsWith(">")) {
                operator = token.substring(1, token.length()-1); // izbacujemo < i >
            }
            else {
                newUris = rdfService.advancedSearch(idOfHealthCard, token);
                if(operator == null) {
                    uris = addOnlyNew(uris, newUris);
                }
                else if(operator.equals("and")) {
                    uris = intersection(uris, newUris);

                }
                else if(operator.equals("or")) {
                    uris = addOnlyNew(uris, newUris);
                }
                else if(operator.equals("not")) {
                    notUris = addOnlyNew(notUris, newUris);
                }
                else {
                    throw new Exception("Logicki operator mora biti and, or ili not");
                }

                operator = null;
            }
        }

        uris = not(uris, notUris);

        if(uris.isEmpty()) {
            return "There are no results for:  " + text;
        }
        else {
            StringBuilder sb = new StringBuilder("");
            uris.stream()
                    .forEach(uri -> {
                                sb.append("<a style=\"color: #00ff00\" href=\"");
                                String[] tokens = uri.getValue().split("/");
                                String idNum = tokens[tokens.length - 1];
                                sb.append("http://localhost:8081/api/search/");
                                sb.append(uri.getVarName());
                                sb.append("/");
                                sb.append(idNum);
                                sb.append("?text=");
                                sb.append(text);
                                sb.append("\">");
                                sb.append(uri.getValue());
                                sb.append("</a>");
                                sb.append("<br/>");
                            }
                    );
            return sb.toString();
        }
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

    @Override
    public void updatePatientAddNotification(String patientId, String idOfReview, String oldDateAndTime,
                                             String newDateAndTime, boolean firstNotification) throws Exception {
        patientRepository.updatePatientAddNotification(patientId, idOfReview, oldDateAndTime, newDateAndTime, firstNotification);
    }

    @Override
    public String getNotifications(String idOfUser) throws Exception {
        String obavestenjaXml = patientRepository.getNotifications(idOfUser);

        String xHTML = null;
        try {
            xHTML = transformationService.generateHTML(obavestenjaXml, obavestenjaXsl.getFile());
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?", "");
        return xHTML;
    }

}
