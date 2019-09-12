package com.svj.zis.controller;

import com.svj.zis.model.User;
import com.svj.zis.service.SearchService;
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
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/pacijent/{idNum}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> searchPatient(@PathVariable("idNum") String idNum,
                                                @RequestParam(name = "text", required = false) String text){
        try {
            if(text == null) text = "";
            else text = text.split("\\s+")[0]; // uzmi samo prvi parametar

            String resursXml = searchService.getPatientResource(idNum, text);
            return new ResponseEntity<String>(resursXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/lekar/{idNum}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> searchDoctor(@PathVariable("idNum") String idNum,
                                               @RequestParam(name = "text", required = false) String text) {
        try {
            if(text == null) text = "";
            else text = text.split("\\s+")[0]; // uzmi samo prvi parametar

            String resursXml = searchService.getDoctorResource(idNum, text);
            return new ResponseEntity<String>(resursXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/izvestaj/{idNum}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> searchReport(@PathVariable("idNum") String idNum,
                                               @RequestParam(name = "text", required = false) String text) {
        try {
            if(text == null) text = "";
            else text = text.split("\\s+")[0]; // uzmi samo prvi parametar

            String resursXml = searchService.getReportResource(idNum, text);
            return new ResponseEntity<String>(resursXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/izvestaj/{idNum}/pdf", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<byte[]> searchReportPdf(@PathVariable("idNum") String idNum,
                                               @RequestParam(name = "text", required = false) String text) {
        try {
            if(text == null) text = "";
            else text = text.split("\\s+")[0]; // uzmi samo prvi parametar

            byte[] pdfBytes = new byte[5]; // searchService.getReportResourcePdf(idNum, text);
            return new ResponseEntity<byte[]>(pdfBytes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/lekarski_recept/{idNum}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> searchDoctorReceipt(@PathVariable("idNum") String idNum,
                                               @RequestParam(name = "text", required = false) String text) {
        try {
            if(text == null) text = "";
            else text = text.split("\\s+")[0]; // uzmi samo prvi parametar

            String resursXml = searchService.getDoctorReceiptResource(idNum, text);
            return new ResponseEntity<String>(resursXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/uput_za_laboratoriju/{idNum}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> searchReferralForLab(@PathVariable("idNum") String idNum,
                                                      @RequestParam(name = "text", required = false) String text) {
        try {
            if(text == null) text = "";
            else text = text.split("\\s+")[0]; // uzmi samo prvi parametar

            String resursXml = searchService.getReferralForLab(idNum, text);
            return new ResponseEntity<String>(resursXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/uput_za_specijalisticki_pregled/{idNum}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> searchReferralForSpecialistExamination(@PathVariable("idNum") String idNum,
                                                      @RequestParam(name = "text", required = false) String text) {
        try {
            if(text == null) text = "";
            else text = text.split("\\s+")[0]; // uzmi samo prvi parametar

            String resursXml = searchService.getReferralForSpecialistExamination(idNum, text);
            return new ResponseEntity<String>(resursXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/lek/{idNum}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> searchMedicament(@PathVariable("idNum") String idNum,
                                                 @RequestParam(name = "text", required = false) String text) {
        try {
            if(text == null) text = "";
            else text = text.split("\\s+")[0]; // uzmi samo prvi parametar

            String resursXml = searchService.getMedicament(idNum, text);
            return new ResponseEntity<String>(resursXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
