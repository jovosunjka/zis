package com.svj.zis.service;

import com.svj.zis.repository.ReferralForLabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferralForLabServiceImpl implements ReferralForLabService {

    @Autowired
    private ReferralForLabRepository referralForLabRepository;


    @Override
    public String getReferralsForLab(String numberOfHeathCard) throws Exception {
        return referralForLabRepository.getReferralsForLab(numberOfHeathCard);
    }

    @Override
    public String getReferralForLab(String id) throws Exception {
        return referralForLabRepository.getReferralForLab(id);
    }
}
