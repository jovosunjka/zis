package com.svj.zis.service;

import com.svj.zis.model.Lek;
import com.svj.zis.model.Lekar;
import com.svj.zis.model.ZdravstveniKarton;

public interface ReportService {
    String getReports(String idOfPatient) throws Exception;

    String getReport(String id) throws Exception;

    String makeReport(Lekar lekar, ZdravstveniKarton zdravstveniKarton, String dijagnoza, String anamneza,
                    String terapija) throws Exception;

}
