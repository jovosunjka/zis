package com.svj.zis.service;

import com.svj.zis.model.Lekar;
import com.svj.zis.model.ZdravstveniKarton;

public interface ReferralForLabService {

    String getReferralsForLab(String numberOfHeathCard) throws Exception;

    String getReferralForLab(String id) throws Exception;

    void makeReferralForLab(Lekar lekar, ZdravstveniKarton zdravstveniKarton,
                            String zdravstvenaUstanovaKojaSalje, String zdravstvenaUstanovaKojaPrima,
                            String kadJeUzetMaterijal, String klinickaDijagnoza, String tipPregleda, String potpisLekara,
                            String pecat) throws Exception;
}
