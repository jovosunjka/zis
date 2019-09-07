package com.svj.zis.service;

import com.svj.zis.model.ZdravstveniKarton;
import com.svj.zis.model.ZdravstveniKartoni;

import javax.xml.datatype.XMLGregorianCalendar;

public interface HealthCardService {

    ZdravstveniKarton getHealthCard(String numberOfHealthCard) throws Exception;

    void updateChosenDoctor(String numberOfHealthCard, String idOfDoctor) throws Exception;

    String getHealthCardXml(String numberOfHealthCard) throws Exception;

    String getHealthCards(String idOfDoctor) throws Exception;

    void editPatientBasicInformations(String numberOfHealthCard, String jmbg, String lbo, String ime, String prezime, String imeJednogRoditelja, XMLGregorianCalendar datumRodjenja, String ulica, int broj, String mesto, String opstina, String telefon, String our, String pol, String bracnoStanje, String osnovOslobadjanjaOdParticipacije) throws Exception;

    String getHealthCardsBasicSearch(String idOfDoctor, String text) throws Exception;
}
