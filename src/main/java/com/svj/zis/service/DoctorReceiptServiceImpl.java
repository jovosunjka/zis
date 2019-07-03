package com.svj.zis.service;

import com.svj.zis.repository.DoctorReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorReceiptServiceImpl implements DoctorReceiptService {

    @Autowired
    private DoctorReceiptRepository doctorReceiptRepository;


    @Override
    public String getDoctorRecipes(String numberOfHeathCard) throws Exception {
        return doctorReceiptRepository.getDoctorRecipes(numberOfHeathCard);
    }
}
