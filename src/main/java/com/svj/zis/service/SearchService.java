package com.svj.zis.service;


public interface SearchService {

    String getPatientResource(String idNum, String text) throws Exception;

    String getDoctorResource(String idNum, String text) throws Exception;

    String getReportResource(String idNum, String text) throws Exception;

    String getDoctorReceiptResource(String idNum, String text) throws Exception;

    String getReferralForLab(String idNum, String text) throws Exception;

    String getReferralForSpecialistExamination(String idNum, String text) throws Exception;

    String getMedicament(String idNum, String text) throws Exception;
}
