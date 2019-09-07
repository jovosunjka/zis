package com.svj.zis.service;

import com.svj.zis.dto.ReviewsDto;

public interface NurseService {
    String getAllDoctors();

    String getReviews(String idOfDoctor) throws Exception;

    void editReviews(ReviewsDto reviewsDto) throws Exception;
}
