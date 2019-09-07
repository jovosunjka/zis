package com.svj.zis.service;

import com.svj.zis.dto.ReviewsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;
import java.io.IOException;

@Service
public class NurseServiceImpl implements NurseService {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private TransformationService transformationService;


    private ClassPathResource lekariXsl = new ClassPathResource("xsl/xsl_for_patient_page/lekari.xsl");
    private ClassPathResource preglediXsl = new ClassPathResource("xsl/xsl_for_nurse_page/pregledi.xsl");

    @Override
    public String getAllDoctors() {
        //String processInstruction = "<?xml-stylesheet type=\"text/xsl\" href=\"src/main/resources/xsl/lekari.xsl\"?>\n";
        String doctorsXml = doctorService.getAllDoctors();
        //doctorsXml = processInstruction + doctorsXml;
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
    public String getReviews(String idOfDoctor) throws Exception {
        return doctorService.getReviews(idOfDoctor, preglediXsl.getFile());
    }

    @Override
    public void editReviews(ReviewsDto reviewsDto) throws Exception {
        reviewService.editReviews(reviewsDto);
    }
}
