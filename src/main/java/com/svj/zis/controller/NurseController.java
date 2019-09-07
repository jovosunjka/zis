package com.svj.zis.controller;


import com.svj.zis.dto.BasicInfoDto;
import com.svj.zis.dto.DoctorReceiptDto;
import com.svj.zis.dto.ReportDto;
import com.svj.zis.dto.ReviewsDto;
import com.svj.zis.model.User;
import com.svj.zis.service.DoctorService;
import com.svj.zis.service.NurseService;
import com.svj.zis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
// enable CORS at Spring Security level (https://spring.io/blog/2015/06/08/cors-support-in-spring-framework)
// U /com/svj/zis/security/SecurityConfigura.java moramo ukljuciti CORS da bismo u Controller-ima mogli koristiti @CrossOrigin anotacije
// i tako resili probleme sa CORS-om
@RestController
@RequestMapping(value = "/nurse")
public class NurseController {

    @Autowired
    private UserService userService;

    @Autowired
    private NurseService nurseService;

    private String firstPartOfDoctorId = "http://www.svj.com/zis/osobe/lekar/";

    @RequestMapping(value = "/all-doctors", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getAllDoctors() {
        String lekariXml = null;
        try {
            lekariXml = nurseService.getAllDoctors();
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<String>(lekariXml, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-reviews", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getReviews(@RequestParam("idNumOfDoctor") int idNumOfDoctor) {
        try {
            String preglediXml = nurseService.getReviews(firstPartOfDoctorId + idNumOfDoctor);
            return new ResponseEntity<String>(preglediXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/edit-reviews", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity editReviews(@RequestBody ReviewsDto reviewsDto) {
        try {
            nurseService.editReviews(reviewsDto);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
