package com.svj.zis.service;

import com.svj.zis.model.ZdravstveniKarton;
import com.svj.zis.repository.HealthCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthCardServiceImpl implements HealthCardService {

    @Autowired
    private HealthCardRepository healthCardRepository;


    @Override
    public ZdravstveniKarton getHealthCard(String numberOfHealthCard) throws Exception {
        return healthCardRepository.findByNumberOfHealthCard(numberOfHealthCard);
    }

    public void updateChosenDoctor(String numberOfHealthCard, String idOfDoctor) throws Exception {
        healthCardRepository.updateChosenDoctor(numberOfHealthCard, idOfDoctor);
    }

    @Override
    public String getHealthCardXml(String numberOfHealthCard) throws Exception {
        return healthCardRepository.getHealthCardXml(numberOfHealthCard);
    }
}
