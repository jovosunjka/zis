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

    @RequestMapping(value = "/pacijent/{id}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> searchPacijent(@PathVariable("id") String id) {
        try {
            String resursXml = searchService.getResource(id);
            return new ResponseEntity<String>(resursXml, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
