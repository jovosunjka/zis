package com.svj.zis.service;

import com.svj.zis.model.Lek;
import com.svj.zis.repository.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentServiceImpl implements MedicamentService {

    @Autowired
    private MedicamentRepository medicamentRepository;


    @Override
    public String getMedicament(String id) throws Exception {
        return medicamentRepository.getMedicament(id);
    }

    @Override
    public Lek getMedicamentByCode(String code) throws Exception {
        return medicamentRepository.getMedicamentByCode(code);
    }
}
