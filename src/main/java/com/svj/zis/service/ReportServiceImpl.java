package com.svj.zis.service;

import com.svj.zis.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public String getReports(String idOfPatient) throws Exception {
        return reportRepository.getReports(idOfPatient);
    }
}
