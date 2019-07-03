package com.svj.zis.service;

public interface PatientService {

    String getAllDoctors();

    String getDoctor(String idOfPatient) throws Exception;

    void selectDoctor(String idOfPatient, String idOfDoctor) throws Exception;

    String getFreeReviews(String idOfPatient) throws Exception;

    String getOrderedReviews(String patientId) throws Exception;

    void orederReview(String idOfPatient, String idOfReview) throws Exception;

    String getHealthCard(String idOfPatient) throws Exception;

    String getAllReports(String idOfPatient) throws Exception;

    String getReferralsForLab(String idOfPatient) throws Exception;

    String getReferralsForSpecialistExamination(String idOfPatient) throws Exception;

    String getDoctorRecipes(String idOfPatient) throws Exception;
}
