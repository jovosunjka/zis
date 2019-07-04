package com.svj.zis.service;

import com.svj.zis.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;


    @Override
    public String getFreeReviews(String doctorId) throws Exception {
        return reviewRepository.findFreeReviewsByDoctorId(doctorId);
    }

    @Override
    public String getOrderedReviews(String patientId) throws Exception {
        return reviewRepository.findOrederedReviewsByPatientId(patientId);
    }

    @Override
    public String getOrderedReviewsByDoctorId(String doctorId) throws Exception {
        return reviewRepository.findOrderedReviewsByDoctorId(doctorId);
    }

    @Override
    public void updateReview(String idOfReview, String idOfPatient, String firstNamePatient, String lastNamePatient) throws Exception {
        reviewRepository.updateReview(idOfReview, idOfPatient, firstNamePatient, lastNamePatient);
    }
}
