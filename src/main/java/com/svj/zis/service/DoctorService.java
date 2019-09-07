package com.svj.zis.service;

import com.svj.zis.dto.ReportDto;
import com.svj.zis.model.Lekar;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;

public interface DoctorService {

    String getDoctor(String id) throws Exception;

    Lekar findDoctor(String id) throws Exception;

    String getAllDoctors();

    String getNotOverburdenedDoctors() throws Exception;

    String getOrderedReviews(String idOfUser) throws Exception;

    String getReviews(String idOfDoctor, File xslFile) throws Exception;

    String getPatients(String idOfUser) throws Exception;

    String getBasicInformations(String numberOfHealthCard) throws Exception;

    void editPatientBasicInformations(String numberOfHealthCard, String jmbg, String lbo, String ime, String prezime, String imeJednogRoditelja, XMLGregorianCalendar datumRodjenja, String ulica, int broj, String mesto, String opstina, String telefon, String our, String pol, String bracnoStanje, String osnovOslobadjanjaOdParticipacije) throws Exception;

    String getPatientsBasicSearch(String idOfUser, String text) throws Exception;

    void makeReport(String idOfUser, String idOfPatient, String dijagnoza, String anamneza, String terapija) throws Exception;


    void makeDoctorReceipt(String idOfUser, String idOfPatient, String nazivZdrastveneUstanove, String drzava, String potpisLekara, String naziv, long sifra, String dijagnoza, int redniBroj, int kolicina, String rp) throws Exception;
}
