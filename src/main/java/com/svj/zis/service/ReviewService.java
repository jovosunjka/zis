package com.svj.zis.service;

import com.svj.zis.dto.ReviewsDto;

public interface ReviewService {

    String getFreeReviews(String doctorId) throws Exception;

    String getReviewsByDoctorId(String doctorId) throws Exception;

    String getOrderedReviews(String patientId) throws Exception;

    String getOrderedReviewsByDoctorId(String doctorId) throws Exception;

    void updateReview(String idOfReview, String idOfPatient, String firstNamePatient, String lastNamePatient) throws Exception;

    void editReviews(ReviewsDto reviewsDto) throws Exception;

    void updatePatientAddNotification(String patientId, String idOfReview, String oldDateAndTime, String newDateAndTime,
                                      boolean firstNotification) throws Exception;
}
