package com.svj.zis.service;

import com.svj.zis.model.Lek;

public interface MedicamentService {
    String getMedicament(String id) throws Exception;

    String getMedicamentsByDiagnosis(String diagnosis) throws Exception;

    Lek getMedicamentByCode(String code) throws Exception;
}
