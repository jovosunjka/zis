package com.svj.zis.service;

import com.svj.zis.dto.ReviewsDto;
import com.svj.zis.model.Lekar;
import com.svj.zis.model.Pacijent;
import com.svj.zis.model.Pregled;
import com.svj.zis.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;


    @Override
    public String getFreeReviews(String doctorId) throws Exception {
        return reviewRepository.findFreeReviewsByDoctorId(doctorId);
    }

    @Override
    public String getReviewsByDoctorId(String doctorId) throws Exception {
        return reviewRepository.findReviewsByDoctorId(doctorId);
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

    @Override
    public void editReviews(ReviewsDto reviewsDto) throws Exception {
        String idOfDoctor = reviewsDto.getDoctor().getId();
        Lekar lekar;
        Pregled pregled;
        Pacijent pacijent;
        boolean firstNotification;

        for(ReviewsDto.Reviews.Review r : reviewsDto.getReviews().getReview()) {
            if (!r.getId().equals("Will be generated")) {
                pregled = reviewRepository.getReview(r.getId());
                if (pregled != null) {
                    if (!pregled.getDatumIVreme().equals(r.getDateAndTime())) {
                        reviewRepository.updateReviewDateAndTime(r.getId(), r.getDateAndTime());
                        if(!pregled.getPacijent().getId().equals("")) {
                            pacijent = patientService.getPatientByPatientId(pregled.getPacijent().getId());
                            firstNotification = pacijent.getObavestenja().getObavestenje().size() == 0;
                            updatePatientAddNotification(pregled.getPacijent().getId(), r.getId(),
                                    pregled.getDatumIVreme().toXMLFormat(), r.getDateAndTime().toXMLFormat(), firstNotification);
                        }
                    }

                }
            }
            else {
                lekar = doctorService.findDoctor(idOfDoctor);
                reviewRepository.makeReview(lekar, r.getDateAndTime().toXMLFormat());
            }
        }
    }

    @Override
    public void updatePatientAddNotification(String patientId, String idOfReview, String oldDateAndTime,
                                             String newDateAndTime, boolean firstNotification) throws Exception {
        patientService.updatePatientAddNotification(patientId, idOfReview, oldDateAndTime, newDateAndTime, firstNotification);
    }
}
