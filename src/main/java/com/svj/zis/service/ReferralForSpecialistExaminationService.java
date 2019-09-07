package com.svj.zis.service;

public interface ReferralForSpecialistExaminationService {
    String getReferralsForSpecialistExamination(String numberOfHeathCard) throws Exception;

    String getReferralForSpecialistExamination(String id) throws Exception;
}
