package com.svj.zis.service;

import com.svj.zis.model.Lekar;
import com.svj.zis.model.ZdravstveniKarton;

public interface ReferralForSpecialistExaminationService {
    String getReferralsForSpecialistExamination(String numberOfHeathCard) throws Exception;

    String getReferralForSpecialistExamination(String id) throws Exception;

    void makeReferralForSpecExamination(Lekar lekar, ZdravstveniKarton zdravstveniKarton,
                                        String zdravstvenaUstanovaKojaSalje, String zdravstvenaUstanovaKojaPrima,
                                        Lekar specijalista, String potpisLekara, String pecat) throws Exception;
}
