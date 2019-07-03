package com.svj.zis.service;

import com.svj.zis.model.ZdravstveniKarton;

public interface HealthCardService {

    ZdravstveniKarton getHealthCard(String numberOfHealthCard) throws Exception;

    void updateChosenDoctor(String numberOfHealthCard, String idOfDoctor) throws Exception;

    String getHealthCardXml(String numberOfHealthCard) throws Exception;
}
