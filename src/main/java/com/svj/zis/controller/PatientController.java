package com.svj.zis.controller;

import com.svj.zis.model.Pacijent;
import com.svj.zis.model.User;
import com.svj.zis.service.PatientService;
import com.svj.zis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin // enable CORS at Spring Security level (https://spring.io/blog/2015/06/08/cors-support-in-spring-framework)
// U /com/svj/zis/security/SecurityConfigura.java moramo ukljuciti CORS da bismo u Controller-ima mogli koristiti @CrossOrigin anotacije
// i tako resili probleme sa CORS-om
@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;

    private String firstPartOfPatientId = "http://www.svj.com/zis/osobe/pacijent/";



    @RequestMapping(value = "/all-doctors", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getAllDoctors() {
        String lekariXml = patientService.getAllDoctors();

        return new ResponseEntity<String>(lekariXml, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-doctor", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getDoctor() {
        User loggedUser = null;

        try {
            loggedUser = userService.getLoggedUser();
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        try {
            String lekarXml = patientService.getDoctor(loggedUser.getId());
            return new ResponseEntity<String>(lekarXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/select-doctor", method = RequestMethod.PUT)
    public ResponseEntity selectDoctor(@RequestParam("id-of-doctor") String idOfDoctor) {
        User loggedUser = null;

        try {
            loggedUser = userService.getLoggedUser();
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        try {
            patientService.selectDoctor(loggedUser.getId(), idOfDoctor);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/free-reviews", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getFreeReviews() {
        User loggedUser = null;

        try {
            loggedUser = userService.getLoggedUser();
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        try {
            String preglediXml = patientService.getFreeReviews(loggedUser.getId());
            return new ResponseEntity<String>(preglediXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/ordered-reviews", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getOrderedReviews() {
        User loggedUser = null;

        try {
            loggedUser = userService.getLoggedUser();
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        try {
            String preglediXml = patientService.getOrderedReviews(loggedUser.getId());
            return new ResponseEntity<String>(preglediXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/order-review", method = RequestMethod.PUT)
    public ResponseEntity orderReview(@RequestParam("id-of-review") String idOfReview) {
        User loggedUser = null;

        try {
            loggedUser = userService.getLoggedUser();
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        try {
            patientService.orderReview(loggedUser.getId(), idOfReview);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = {"/health-card-basic-informations", "/health-card-basic-informations/{idOfPatientNum}"}, method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getHealthCardBasicInformations(@PathVariable(name = "idOfPatientNum", required = false) String idOfPatientNum) {
        Pacijent pacijent = null;
        try {
            pacijent = patientService.getPatient(idOfPatientNum);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        try {
            String zdravstveniKartonXml = patientService.getHealthCard(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona());
            return new ResponseEntity<String>(zdravstveniKartonXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = {"/all-reports", "/all-reports/{idOfPatientNum}"}, method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getAllReports(@PathVariable(name = "idOfPatientNum", required = false) String idOfPatientNum) {
        Pacijent pacijent = null;
        try {
            pacijent = patientService.getPatient(idOfPatientNum);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        try {
            String izvestajiXml = patientService.getAllReports(pacijent.getId());
            return new ResponseEntity<String>(izvestajiXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = {"/ref-spec-examination", "/ref-spec-examination/{idOfPatientNum}"}, method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getAllReferralsForSpecialistExamination(@PathVariable(name = "idOfPatientNum", required = false) String idOfPatientNum) {
        Pacijent pacijent = null;
        try {
            pacijent = patientService.getPatient(idOfPatientNum);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }


        try {
            String uputiZaSpecijalistickiPregledXml = patientService.getReferralsForSpecialistExamination(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona());
            return new ResponseEntity<String>(uputiZaSpecijalistickiPregledXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = {"/ref-for-lab", "/ref-for-lab/{idOfPatientNum}"}, method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getAllReferralsForLab(@PathVariable(name = "idOfPatientNum", required = false) String idOfPatientNum) {
        Pacijent pacijent = null;
        try {
            pacijent = patientService.getPatient(idOfPatientNum);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        try {
            String uputiZaLaboratorijuXml = patientService.getReferralsForLab(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona());
            return new ResponseEntity<String>(uputiZaLaboratorijuXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = {"/all-recipes", "/all-recipes/{idOfPatientNum}"}, method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getAllRecipes(@PathVariable(name = "idOfPatientNum", required = false) String idOfPatientNum) {
        Pacijent pacijent = null;
        try {
            pacijent = patientService.getPatient(idOfPatientNum);
        } catch (Exception e) {
            System.out.println("*************" + e.getMessage());
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        try {
            String lekarskiReceptiXml = patientService.getDoctorRecipes(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona());
            return new ResponseEntity<String>(lekarskiReceptiXml, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("##############" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = {"/basic-search", "/basic-search/{idOfPatientNum}"}, method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> basicSearch(@PathVariable(name = "idOfPatientNum", required = false) String idOfPatientNum,
                                              @RequestParam("text") String text) {
        Pacijent pacijent = null;
        try {
            pacijent = patientService.getPatient(idOfPatientNum);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        try {
            String zdravstveniKartonXml = patientService.basicSearchHealthCard(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona(), text);
            return new ResponseEntity<String>(zdravstveniKartonXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = {"/basic-search", "/advanced-search/{idOfPatientNum}"}, method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> advancedSearch(@PathVariable(name = "idOfPatientNum", required = false) String idOfPatientNum,
                                              @RequestParam("text") String text) {
        Pacijent pacijent = null;
        try {
            pacijent = patientService.getPatient(idOfPatientNum);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        try {
            String zdravstveniKartonXml = patientService.advancedSearchHealthCard(pacijent.getZdravstveniKarton().getBrojZdravstvenogKartona(), text);
            return new ResponseEntity<String>(zdravstveniKartonXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
