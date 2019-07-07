package com.svj.zis.service;

import com.svj.zis.model.Pacijent;

import java.io.IOException;
import java.util.Optional;

public interface PatientService {

    String getAllDoctors();

    String getDoctor(String idOfUser) throws Exception;

    void selectDoctor(String idOfUser, String idOfDoctor) throws Exception;

    String getFreeReviews(String idOfUser) throws Exception;

    String getOrderedReviews(String patientId) throws Exception;

    String getHealthCard(String healthCardNumber) throws Exception;

    String getAllReports(String idOfPatient) throws Exception;

    String getReferralsForLab(String healthCardNumber) throws Exception;

    String getReferralsForSpecialistExamination(String healthCardNumber) throws Exception;

    String getDoctorRecipes(String healthCardNumber) throws Exception;

    void orderReview(String idOfUser, String idOfReview) throws Exception;

    Pacijent getPatientByUserId(String idOfUser) throws Exception;

    Pacijent getPatient(String idOfPatientNum) throws Exception;

    String basicSearchHealthCard(String healthCardNumber, String text) throws Exception;

    String advancedSearchHealthCard(String healthCardNumber, String text) throws IOException;
}
