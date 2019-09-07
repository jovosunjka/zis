package com.svj.zis.service;

import com.svj.zis.model.Lekar;
import com.svj.zis.model.ZdravstveniKarton;
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

    @Override
    public String getReport(String id) throws Exception {
        return reportRepository.getReport(id);
    }

    @Override
    public void makeReport(Lekar lekar, ZdravstveniKarton zdravstveniKarton, String anamneza, String dijagnoza, String terapija) throws Exception {
        reportRepository.makeReport(lekar, zdravstveniKarton, dijagnoza, anamneza, terapija);
    }
}
