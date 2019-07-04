package com.svj.zis.controller;

import com.svj.zis.dto.Tokendto;
import com.svj.zis.dto.Userdto;
import com.svj.zis.security.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private TokenUtils tokenUtils;

    //@Autowired
    //private PasswordEncoder passwordEncoder;


    @RequestMapping(value="/login", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Tokendto> login(@RequestBody Userdto userDTO) {
        /*String pera = passwordEncoder.encode("pera");
        String zika = passwordEncoder.encode("zika");
        String mika = passwordEncoder.encode("mika");
        String sima = passwordEncoder.encode("sima");
        String djura = passwordEncoder.encode("djura");
        System.out.println();*/
        Tokendto tokendto = new Tokendto();

        try {
            // Perform the authentication
            UsernamePasswordAuthenticationToken userInfo = new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(userInfo);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Reload user details so we can generate token
            //authentication.getDetails()
            UserDetails details = userDetailsService.loadUserByUsername(userDTO.getUsername());
            String generatedToken = tokenUtils.generateToken(details);

            tokendto.setValue(generatedToken);
            return new ResponseEntity<Tokendto>(tokendto, HttpStatus.OK);
            //return new ResponseEntity<String>(generatedToken, HttpStatus.OK);
        }
        catch (Exception e) {
            tokendto.setValue("");
            return new ResponseEntity<Tokendto>(tokendto, HttpStatus.BAD_REQUEST);
        }

    }
}
