package com.svj.zis.service;

import com.svj.zis.model.Lek;
import com.svj.zis.model.Lekar;
import com.svj.zis.model.ZdravstveniKarton;
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

    @Override
    public String getDoctorRecipt(String id) throws Exception {
        return doctorReceiptRepository.getDoctorReceipt(id);
    }

    @Override
    public void makeDoctorReceipt(Lekar lekar, ZdravstveniKarton zdravstveniKarton, Lek lek, String nazivZdrastveneUstanove, String drzava, String potpisLekara, String dijagnoza, int redniBroj, int kolicina, String rp) throws Exception {
        doctorReceiptRepository.makeDoctorReceipt(lekar, zdravstveniKarton, lek, nazivZdrastveneUstanove, drzava, potpisLekara, dijagnoza, redniBroj, kolicina, rp);
    }
}
