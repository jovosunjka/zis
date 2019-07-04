package com.svj.zis.service;

public interface ReviewService {

    String getFreeReviews(String doctorId) throws Exception;

    String getOrderedReviews(String patientId) throws Exception;

    String getOrderedReviewsByDoctorId(String doctorId) throws Exception;

    void updateReview(String idOfReview, String idOfPatient, String firstNamePatient, String lastNamePatient) throws Exception;
}
