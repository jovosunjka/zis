package com.svj.zis.service;

import com.svj.zis.model.Lek;
import com.svj.zis.model.Lekar;
import com.svj.zis.model.ZdravstveniKarton;

public interface DoctorReceiptService {

    String getDoctorRecipes(String numberOfHeathCard) throws Exception;

    String getDoctorRecipt(String id) throws Exception;

    void makeDoctorReceipt(Lekar lekar, ZdravstveniKarton zdravstveniKarton, Lek lek, String nazivZdrastveneUstanove, String drzava, String potpisLekara, String dijagnoza, int redniBroj, int kolicina, String rp) throws Exception;
}
