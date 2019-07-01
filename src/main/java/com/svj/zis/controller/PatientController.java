package com.svj.zis.controller;

import com.svj.zis.model.Lekar;
import com.svj.zis.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;


    @RequestMapping(value = "/all-doctors", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getAllDoctors() {
        String lekariXml = patientService.getAllDoctors();

        return new ResponseEntity<String>(lekariXml, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-doctor", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Lekar> getDoctor() {
        Lekar lekar = patientService.getDoctor();
        return new ResponseEntity<Lekar>(lekar, HttpStatus.OK);
    }

    @RequestMapping(value = "/select-doctor", method = RequestMethod.PUT)
    public ResponseEntity selectDoctor(@RequestParam("id-of-doctor") String idOfDoctor) {
        patientService.selectDoctor(idOfDoctor);
        return new ResponseEntity(HttpStatus.OK);
    }
}
