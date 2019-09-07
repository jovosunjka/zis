package com.svj.zis;


import com.svj.zis.repository.RdfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ExtractAndSaveMetadataInJenaDB {

    @Autowired
    private RdfRepository rdfRepository;

    private static ClassPathResource[] xmls = {
            new ClassPathResource("xml/izvestaji.xml"),
            new ClassPathResource("xml/lekari.xml"),
            new ClassPathResource("xml/lekarski_recepti.xml"),
            new ClassPathResource("xml/lekovi.xml"),
            new ClassPathResource("xml/medicinske_sestre.xml"),
            new ClassPathResource("xml/pacijenti.xml"),
            new ClassPathResource("xml/pregledi.xml"),
            new ClassPathResource("xml/uputi_za_laboratoriju.xml"),
            new ClassPathResource("xml/uputi_za_specijalisticki_pregled.xml"),
            //new ClassPathResource("xml/users.xml"),
            new ClassPathResource("xml/zdravstveni_kartoni.xml")
    };


    // @EventListener(ApplicationReadyEvent.class)
    private void extractAndSave() {
        Arrays.stream(xmls).forEach(xml -> {
            try {
                System.out.println("Extract metadata for " + xml + " ...");
                rdfRepository.extractMetadata(xml.getFile());
                System.out.println("Extract metadata for " + xml + " ... done");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
