package com.svj.zis.service;

import com.svj.zis.model.ZdravstveniKarton;
import com.svj.zis.model.ZdravstveniKartoni;
import com.svj.zis.repository.HealthCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.XMLGregorianCalendar;

@Service
public class HealthCardServiceImpl implements HealthCardService {

    @Autowired
    private HealthCardRepository healthCardRepository;


    @Override
    public ZdravstveniKarton getHealthCard(String numberOfHealthCard) throws Exception {
        return healthCardRepository.findByNumberOfHealthCard(numberOfHealthCard);
    }

    public void updateChosenDoctor(String numberOfHealthCard, String idOfDoctor) throws Exception {
        healthCardRepository.updateChosenDoctor(numberOfHealthCard, idOfDoctor);
    }

    @Override
    public String getHealthCardXml(String numberOfHealthCard) throws Exception {
        return healthCardRepository.getHealthCardXml(numberOfHealthCard);
    }

    @Override
    public String getHealthCards(String idOfDoctor) throws Exception {
        return healthCardRepository.getHealthCards(idOfDoctor);
    }

    @Override
    public void editPatientBasicInformations(String numberOfHealthCard, String jmbg, String lbo, String ime, String prezime, String imeJednogRoditelja, XMLGregorianCalendar datumRodjenja, String ulica, int broj, String mesto, String opstina, String telefon, String our, String pol, String bracnoStanje, String osnovOslobadjanjaOdParticipacije) throws Exception {
        healthCardRepository.editPatientBasicInformations(numberOfHealthCard, jmbg, lbo, ime, prezime, imeJednogRoditelja, datumRodjenja, ulica, broj, mesto, opstina, telefon, our, pol, bracnoStanje, osnovOslobadjanjaOdParticipacije);
    }

    @Override
    public String getHealthCardsBasicSearch(String idOfDoctor, String text) throws Exception {
        return healthCardRepository.getHealthCardsBasicSearch(idOfDoctor, text);
    }
}
