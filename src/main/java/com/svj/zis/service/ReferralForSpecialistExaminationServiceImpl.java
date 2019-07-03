package com.svj.zis.service;

import com.svj.zis.repository.ReferralForSpecialistExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferralForSpecialistExaminationServiceImpl implements ReferralForSpecialistExaminationService {

    @Autowired
    private ReferralForSpecialistExaminationRepository referralForSpecialistExaminationRepository;


    @Override
    public String getReferralsForSpecialistExamination(String numberOfHeathCard) throws Exception {
        return referralForSpecialistExaminationRepository.getReferralsForSpecialistExamination(numberOfHeathCard);
    }
}
