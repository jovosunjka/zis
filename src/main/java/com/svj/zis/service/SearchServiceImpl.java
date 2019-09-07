package com.svj.zis.service;

import com.svj.zis.model.Pacijent;
import com.svj.zis.repository.RdfRepository;
import com.svj.zis.repository.ResourceRepository;
import com.svj.zis.repository.SearchRdfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.HashMap;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private TransformationService transformationService;

    @Autowired
    private HealthCardService healthCardService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private DoctorReceiptService doctorReceiptService;

    @Autowired
    private ReferralForLabService referralForLabService;

    @Autowired
    private ReferralForSpecialistExaminationService referralForSpecialistExaminationService;

    @Autowired
    private MedicamentService medicamentService;

    private ClassPathResource lekarPretragaXsl = new ClassPathResource("xsl/xsl_for_patient_page/lekar_pretraga.xsl");
    private ClassPathResource lekarXsl = new ClassPathResource("xsl/xsl_for_patient_page/lekar.xsl");
    private ClassPathResource pacijentPretragaXsl = new ClassPathResource("xsl/xsl_for_patient_page/pacijent_pretraga.xsl");
    private ClassPathResource pacijentXsl = new ClassPathResource("xsl/xsl_for_patient_page/pacijent.xsl");
    private ClassPathResource izvestajPretragaXsl = new ClassPathResource("xsl/xsl_for_patient_page/izvestaj_pretraga.xsl");
    private ClassPathResource izvestajXsl = new ClassPathResource("xsl/xsl_for_patient_page/izvestaj.xsl");
    private ClassPathResource lekarskiReceptPretragaXsl = new ClassPathResource("xsl/xsl_for_patient_page/lekarski_recept_pretraga.xsl");
    private ClassPathResource lekarskiReceptXsl = new ClassPathResource("xsl/xsl_for_patient_page/lekarski_recept.xsl");
    private ClassPathResource uputZaLaboratorijuPretragaXsl = new ClassPathResource("xsl/xsl_for_patient_page/uput_za_laboratoriju_pretraga.xsl");
    private ClassPathResource uputZaLaboratorijuXsl = new ClassPathResource("xsl/xsl_for_patient_page/uput_za_laboratoriju.xsl");
    private ClassPathResource uputZaSpecijalistickiPregledPretragaXsl = new ClassPathResource("xsl/xsl_for_patient_page/uput_za_specijalisticki_pregled_pretraga.xsl");
    private ClassPathResource uputZaSpecijalistickiPregledXsl = new ClassPathResource("xsl/xsl_for_patient_page/uput_za_specijalisticki_pregled.xsl");
    private ClassPathResource lekPretragaXsl = new ClassPathResource("xsl/xsl_for_patient_page/lek_pretraga.xsl");
    private ClassPathResource lekXsl = new ClassPathResource("xsl/xsl_for_patient_page/lek.xsl");

    private static HashMap<String, String> firstPartsOfId;

    static {
        firstPartsOfId = new HashMap<String, String>();
        firstPartsOfId.put("izvestaj", "http://www.svj.com/zis/dokumenti/izvestaj/");
        firstPartsOfId.put("lekar", "http://www.svj.com/zis/osobe/lekar/");
        firstPartsOfId.put("lekarski_recept", "http://www.svj.com/zis/dokumenti/lekarski_recept/");
        firstPartsOfId.put("lek", "http://www.svj.com/zis/dokumenti/lek/");
        firstPartsOfId.put("medicinska_sestra", "http://www.svj.com/zis/osobe/medicinska_sestra/");
        firstPartsOfId.put("pacijent", "http://www.svj.com/zis/osobe/pacijent/");
        firstPartsOfId.put("pregled", "http://www.svj.com/zis/dokumenti/pregled/");
        firstPartsOfId.put("uput_za_laboratoriju", "http://www.svj.com/zis/dokumenti/uput_za_laboratoriju/");
        firstPartsOfId.put("uput_za_specijalisticki_pregled", "http://www.svj.com/zis/dokumenti/uput_za_specijalisticki_pregled/");
        firstPartsOfId.put("user", "http://www.svj.com/zis/osobe/user/");
        firstPartsOfId.put("zdravstveni_karton", "http://www.svj.com/zis/dokumenti/zdravstveni_karton/");
    }


    @Override
    public String getPatientResource(String idNum, String text) throws Exception {
        String id = firstPartsOfId.get("pacijent") + idNum;
        Pacijent pacijent = patientService.getPatientByPatientId(id);
        String zdravstveniKartonXml = healthCardService.getHealthCardXml(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona());

        String xHTML = null;
        try {
            String xslString;
            if(text.trim().equals("")) {
                xslString = resourceRepository.loadFileContent(pacijentXsl.getFile().getPath());
            }
            else {
                String pacijentPretragaXslString = resourceRepository.loadFileContent(pacijentPretragaXsl.getFile().getPath());
                xslString = String.format(pacijentPretragaXslString, text);
            }
            xHTML = transformationService.generateHTML(zdravstveniKartonXml, xslString);
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?\"?", "");
        return xHTML;
    }

    @Override
    public String getDoctorResource(String idNum, String text) throws Exception {
        String id = firstPartsOfId.get("lekar") + idNum;
        String lekarXml = doctorService.getDoctor(id);

        String xHTML = null;
        try {
            String xslString;
            if(text.trim().equals("")) {
                xslString = resourceRepository.loadFileContent(lekarXsl.getFile().getPath());
            }
            else {
                String lekarPretragaXslString = resourceRepository.loadFileContent(lekarPretragaXsl.getFile().getPath());
                xslString = String.format(lekarPretragaXslString, text);
            }
            xHTML = transformationService.generateHTML(lekarXml, xslString);
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?\"?", "");
        return xHTML;
    }

    @Override
    public String getReportResource(String idNum, String text) throws Exception {
        String id = firstPartsOfId.get("izvestaj") + idNum;
        String izvestajXml = reportService.getReport(id);

        String xHTML = null;
        try {
            String xslString;
            if(text.trim().equals("")) {
                xslString = resourceRepository.loadFileContent(izvestajXsl.getFile().getPath());
            }
            else {
                String izvestajPretragaXslString = resourceRepository.loadFileContent(izvestajPretragaXsl.getFile().getPath());
                xslString = String.format(izvestajPretragaXslString, text);
            }
            xHTML = transformationService.generateHTML(izvestajXml, xslString);
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?\"?", "");
        return xHTML;
    }

    @Override
    public String getDoctorReceiptResource(String idNum, String text) throws Exception {
        String id = firstPartsOfId.get("lekarski_recept") + idNum;
        String lekarskiReceptXml = doctorReceiptService.getDoctorRecipt(id);

        String xHTML = null;
        try {
            String xslString;
            if(text.trim().equals("")) {
                xslString = resourceRepository.loadFileContent(lekarskiReceptXsl.getFile().getPath());
            }
            else {
                String izvestajPretragaXslString = resourceRepository.loadFileContent(lekarskiReceptPretragaXsl.getFile().getPath());
                xslString = String.format(izvestajPretragaXslString, text);
            }
            xHTML = transformationService.generateHTML(lekarskiReceptXml, xslString);
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?\"?", "");
        return xHTML;
    }

    @Override
    public String getReferralForLab(String idNum, String text) throws Exception {
        String id = firstPartsOfId.get("uput_za_laboratoriju") + idNum;
        String lekarskiReceptXml = referralForLabService.getReferralForLab(id);

        String xHTML = null;
        try {
            String xslString;
            if(text.trim().equals("")) {
                xslString = resourceRepository.loadFileContent(uputZaLaboratorijuXsl.getFile().getPath());
            }
            else {
                String uputZaLaboratorijuPretragaXslString = resourceRepository.loadFileContent(uputZaLaboratorijuPretragaXsl.getFile().getPath());
                xslString = String.format(uputZaLaboratorijuPretragaXslString, text);
            }
            xHTML = transformationService.generateHTML(lekarskiReceptXml, xslString);
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?\"?", "");
        return xHTML;
    }

    @Override
    public String getReferralForSpecialistExamination(String idNum, String text) throws Exception {
        String id = firstPartsOfId.get("uput_za_specijalisticki_pregled") + idNum;
        String uputZaSpecijalistickiPregledXml = referralForSpecialistExaminationService.getReferralForSpecialistExamination(id);

        String xHTML = null;
        try {
            String xslString;
            if(text.trim().equals("")) {
                xslString = resourceRepository.loadFileContent(uputZaSpecijalistickiPregledXsl.getFile().getPath());
            }
            else {
                String uputZaSpecijalistickiPregledPretragaXslString = resourceRepository.loadFileContent(uputZaSpecijalistickiPregledPretragaXsl.getFile().getPath());
                xslString = String.format(uputZaSpecijalistickiPregledPretragaXslString, text);
            }
            xHTML = transformationService.generateHTML(uputZaSpecijalistickiPregledXml, xslString);
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?\"?", "");
        return xHTML;
    }

    @Override
    public String getMedicament(String idNum, String text) throws Exception {
        String id = firstPartsOfId.get("lek") + idNum;
        String lekXml = medicamentService.getMedicament(id);

        String xHTML = null;
        try {
            String xslString;
            if(text.trim().equals("")) {
                xslString = resourceRepository.loadFileContent(lekXsl.getFile().getPath());
            }
            else {
                String lekXslString = resourceRepository.loadFileContent(lekPretragaXsl.getFile().getPath());
                xslString = String.format(lekXslString, text);
            }
            xHTML = transformationService.generateHTML(lekXml, xslString);
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?\"?", "");
        return xHTML;
    }
}
