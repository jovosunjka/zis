package com.svj.zis.service;

import com.svj.zis.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public String getAllDoctors() {
        return doctorRepository.getAllDoctors();
    }
}
