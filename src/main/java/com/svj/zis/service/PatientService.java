package com.svj.zis.service;

import com.svj.zis.model.Lekar;

public interface PatientService {

    String getAllDoctors();

    Lekar getDoctor();

    void selectDoctor(String idOfDoctor);
}
