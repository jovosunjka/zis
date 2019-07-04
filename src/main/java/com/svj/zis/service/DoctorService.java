package com.svj.zis.service;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;

public interface DoctorService {

    String getDoctor(String id) throws Exception;

    String getAllDoctors();

    String getOrderedReviews(String idOfDoctor) throws Exception;

    String getPatients(String idOfUser) throws Exception;

    String getBasicInformations(String numberOfHealthCard) throws Exception;

    void editPatientBasicInformations(String numberOfHealthCard, String jmbg, String lbo, String ime, String prezime, String imeJednogRoditelja, XMLGregorianCalendar datumRodjenja, String ulica, int broj, String mesto, String opstina, String telefon, String our, String pol, String bracnoStanje, String osnovOslobadjanjaOdParticipacije) throws Exception;
}
