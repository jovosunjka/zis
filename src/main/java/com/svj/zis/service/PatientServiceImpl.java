package com.svj.zis.service;

import com.svj.zis.model.Lekar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;
import java.io.IOException;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private TransformationService transformationService;

    private ClassPathResource lekariXsl = new ClassPathResource("xsl/lekari.xsl");


    @Override
    public String getAllDoctors() {
        String processInstruction = "<?xml-stylesheet type=\"text/xsl\" href=\"src/main/resources/xsl/lekari.xsl\"?>\n";
        String doctorsXml = doctorService.getAllDoctors();
        doctorsXml = processInstruction + doctorsXml;
        String xHTML = null;
        try {
            xHTML = transformationService.generateHTML(doctorsXml, lekariXsl.getFile());
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xHTML = xHTML.replaceAll("\r?\n?", "");
        return xHTML;
    }

    @Override
    public Lekar getDoctor() {
        return null;
    }

    @Override
    public void selectDoctor(String idOfDoctor) {

    }
}
