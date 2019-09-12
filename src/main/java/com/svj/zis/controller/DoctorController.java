package com.svj.zis.controller;


import com.svj.zis.dto.*;
import com.svj.zis.model.Pacijent;
import com.svj.zis.model.User;
import com.svj.zis.service.DoctorService;
import com.svj.zis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin
// enable CORS at Spring Security level (https://spring.io/blog/2015/06/08/cors-support-in-spring-framework)
// U /com/svj/zis/security/SecurityConfigura.java moramo ukljuciti CORS da bismo u Controller-ima mogli koristiti @CrossOrigin anotacije
// i tako resili probleme sa CORS-om
@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    private UserService userService;

    @Autowired
    private DoctorService doctorService;

    private String firstPartOfPatientId = "http://www.svj.com/zis/osobe/pacijent/";
    private String firstPartOfReportId = "http://www.svj.com/zis/dokumenti/izvestaj/";


    @RequestMapping(value = "/ordered-reviews", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getOrderedReviews() {
        User loggedUser = null;

        try {
            loggedUser = userService.getLoggedUser();
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        try {
            String preglediXml = doctorService.getOrderedReviews(loggedUser.getId());
            return new ResponseEntity<String>(preglediXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/get-specialists", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getSpecialists() {
        try {
            String specijalistiXml = doctorService.getSpecialists();
            return new ResponseEntity<String>(specijalistiXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getPatients() {
        User loggedUser = null;

        try {
            loggedUser = userService.getLoggedUser();
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        try {
            String pacijentiXml = doctorService.getPatients(loggedUser.getId());
            return new ResponseEntity<String>(pacijentiXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/health-card_basic-info/{number-of-health-card}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getBasicInformations(@PathVariable("number-of-health-card") String numberOfHealthCard) {
        try {
            String zdravstveniKartonXml = doctorService.getBasicInformations(numberOfHealthCard);
            return new ResponseEntity<String>(zdravstveniKartonXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/basic-info-edit/{number-of-health-card}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity editPatientBasicInformations(@PathVariable("number-of-health-card") String numberOfHealthCard, @RequestBody BasicInfoDto basicInformationsDTO) {
        try {
            doctorService.editPatientBasicInformations(numberOfHealthCard, basicInformationsDTO.getJmbg(), basicInformationsDTO.getLbo(),
                    basicInformationsDTO.getIme(), basicInformationsDTO.getPrezime(), basicInformationsDTO.getImeJednogRoditelja(),
                    basicInformationsDTO.getDatumRodjenja(), basicInformationsDTO.getUlica(), basicInformationsDTO.getBroj(),
                    basicInformationsDTO.getMesto(), basicInformationsDTO.getOpstina(), basicInformationsDTO.getTelefon(),
                    basicInformationsDTO.getOur(), basicInformationsDTO.getPol(), basicInformationsDTO.getBracnoStanje(),
                    basicInformationsDTO.getOsnovOslobadjanjaOdParticipacije());
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/basic-search", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> basicSearch(@RequestParam("text") String text) {
        User loggedUser = null;

        try {
            loggedUser = userService.getLoggedUser();
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        try {
            String pacijentiXml = doctorService.getPatientsBasicSearch(loggedUser.getId(), text);
            return new ResponseEntity<String>(pacijentiXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/get-report/{id-of-report-num}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getReport(@PathVariable("id-of-report-num") String idOfReportNum) {
        String idOfReport = firstPartOfReportId + idOfReportNum;

        try {
            String izvestajXml = doctorService.getReport(idOfReport);
            return new ResponseEntity<String>(izvestajXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/make-report/{id-of-patient-num}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> makeReport(@PathVariable("id-of-patient-num") String idOfPatientNum, @RequestBody ReportDto reportDto) {
        String idOfPatient = firstPartOfPatientId + idOfPatientNum;

        User loggedUser = null;

        try {
            loggedUser = userService.getLoggedUser();
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        try {
            List<String> anamnezaList = reportDto.getAnamneza().getContent().stream()
                    .map( c -> {
                        if (c instanceof JAXBElement) {
                            JAXBElement jaxbElement = (JAXBElement) c;
                            ReportDto.Anamneza.Link link = (ReportDto.Anamneza.Link) jaxbElement.getValue();
                            return "<dokumenti:link id=\""+link.getId()+"\" href=\""+link.getOtherAttributes()
                                    .get(QName.valueOf("href")) + "\" rel=\"pred:referencaNaDokument\"/>";
                        }
                        else {
                            return c.toString();
                        }
                    })
                    .collect(Collectors.toList());
            List<String> terapijaList = reportDto.getTerapija().getContent().stream()
                    .map( c -> {
                        if (c instanceof JAXBElement) {
                            JAXBElement jaxbElement = (JAXBElement) c;
                            ReportDto.Terapija.Link link = (ReportDto.Terapija.Link) jaxbElement.getValue();
                            return "<dokumenti:link id=\""+link.getId()+"\" href=\""+link.getOtherAttributes()
                                    .get(QName.valueOf("href")) + "\" rel=\"pred:referencaNaDokument\"/>";
                        }
                        else {
                            return c.toString();
                        }
                    })
                    .collect(Collectors.toList());
            String newReportIdNum = doctorService.makeReport(loggedUser.getId(), idOfPatient, reportDto.getDijagnoza(),
                    String.join(" ", anamnezaList), String.join(" ", terapijaList));
            return new ResponseEntity<String>(newReportIdNum, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/get-medicaments", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getMedicaments(@RequestParam("diagnosis") String diagnosis) {
        try {
            String lekoviXml = doctorService.getMedicamentsByDiagnosis(diagnosis);
            return new ResponseEntity<String>(lekoviXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/make-doctor-receipt/{id-of-patient-num}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity makeDoctorReceipt(@PathVariable("id-of-patient-num") String idOfPatientNum, @RequestBody DoctorReceiptDto doctorReceiptDto) {
        String idOfPatient = firstPartOfPatientId + idOfPatientNum;

        User loggedUser = null;

        try {
            loggedUser = userService.getLoggedUser();
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        List<String> rpList = doctorReceiptDto.getRp().getContent().stream()
                .map( c -> {
                    if (c instanceof JAXBElement) {
                        JAXBElement jaxbElement = (JAXBElement) c;
                        DoctorReceiptDto.Rp.Link link = (DoctorReceiptDto.Rp.Link) jaxbElement.getValue();
                        return "<dokumenti:link id=\""+link.getId()+"\" href=\""+link.getOtherAttributes()
                                .get(QName.valueOf("href")) + "\" rel=\"pred:referencaNaDokument\"/>";
                    }
                    else {
                        return c.toString();
                    }
                })
                .collect(Collectors.toList());

        try {
            doctorService.makeDoctorReceipt(loggedUser.getId(), idOfPatient, doctorReceiptDto.getUstanova().getNazivZdrastveneUstanove(),
                    doctorReceiptDto.getUstanova().getDrzava(), doctorReceiptDto.getPotpisLekara(), doctorReceiptDto.getPropisaniLek().getNaziv(),
                    doctorReceiptDto.getPropisaniLek().getSifra(), doctorReceiptDto.getDijagnoza(), doctorReceiptDto.getRedniBroj(),
                    doctorReceiptDto.getKolicina(), String.join(" ", rpList));
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/make-referral-for-lab/{id-of-patient-num}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity makeReferralForLab(@PathVariable("id-of-patient-num") String idOfPatientNum, @RequestBody UputZaLaboratorijuDto uputZaLaboratorijuDto) {
        String idOfPatient = firstPartOfPatientId + idOfPatientNum;

        User loggedUser = null;

        try {
            loggedUser = userService.getLoggedUser();
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        try {
            doctorService.makeReferralForLab(loggedUser.getId(), idOfPatient, uputZaLaboratorijuDto.getZdravstvenaUstanovaKojaSalje(),
                    uputZaLaboratorijuDto.getZdravstvenaUstanovaKojaPrima(), uputZaLaboratorijuDto.getKadJeUzetMaterijal().toXMLFormat(),
                    uputZaLaboratorijuDto.getKlinickaDijagnoza(), uputZaLaboratorijuDto.getTipPregleda(),
                    uputZaLaboratorijuDto.getLekarovPotpis(), uputZaLaboratorijuDto.getPecat());
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/make-referral-for-spec-examination/{id-of-patient-num}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity makeReferralForSpecExamination(@PathVariable("id-of-patient-num") String idOfPatientNum,
                                                         @RequestBody UputZaSpecijalistickiPregledDto uputZaSpecijalistickiPregledDto) {
        String idOfPatient = firstPartOfPatientId + idOfPatientNum;

        User loggedUser = null;

        try {
            loggedUser = userService.getLoggedUser();
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        try {
            doctorService.makeReferralForSpecExamination(loggedUser.getId(), idOfPatient, uputZaSpecijalistickiPregledDto.getZdravstvenaUstanovaKojaSalje(),
                    uputZaSpecijalistickiPregledDto.getZdravstvenaUstanovaKojaPrima(), uputZaSpecijalistickiPregledDto.getSpecijalista().getId(),
                    uputZaSpecijalistickiPregledDto.getLekarovPotpis(), uputZaSpecijalistickiPregledDto.getPecat());
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
