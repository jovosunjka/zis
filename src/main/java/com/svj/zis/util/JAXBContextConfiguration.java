package com.svj.zis.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

@Configuration
public class JAXBContextConfiguration {
    private static JAXBContext context;

    static { // trebalo bi da se context inicijalizuje prilikom ucitavanja ove klase
        try {
            context = JAXBContext.newInstance("com.svj.zis.model");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public Marshaller getMarshaller() {
        try {
            return context.createMarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Bean
    public Unmarshaller getUnmarshaller() {
        try {
            return context.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }
}
