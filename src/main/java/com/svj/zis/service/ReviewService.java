package com.svj.zis.service;

public interface ReviewService {

    String getFreeReviews(String doctorId) throws Exception;

    String getOrderedReviews(String patientId) throws Exception;

    void updateReview(String idOfPatient, String idOfReview) throws Exception;
}
