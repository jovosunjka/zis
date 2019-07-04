package com.svj.zis.controller;


import com.svj.zis.dto.BasicInfoDto;
import com.svj.zis.dto.Tokendto;
import com.svj.zis.dto.Userdto;
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
}
