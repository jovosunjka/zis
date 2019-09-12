package com.svj.zis.service;

import com.svj.zis.model.Lekar;
import com.svj.zis.model.ZdravstveniKarton;
import com.svj.zis.repository.ReferralForLabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferralForLabServiceImpl implements ReferralForLabService {

    @Autowired
    private ReferralForLabRepository referralForLabRepository;


    @Override
    public String getReferralsForLab(String numberOfHeathCard) throws Exception {
        return referralForLabRepository.getReferralsForLab(numberOfHeathCard);
    }

    @Override
    public String getReferralForLab(String id) throws Exception {
        return referralForLabRepository.getReferralForLab(id);
    }

    @Override
    public void makeReferralForLab(Lekar lekar, ZdravstveniKarton zdravstveniKarton,
                                   String zdravstvenaUstanovaKojaSalje, String zdravstvenaUstanovaKojaPrima,
                                   String kadJeUzetMaterijal, String klinickaDijagnoza, String tipPregleda, String potpisLekara,
                                   String pecat) throws Exception {
        referralForLabRepository.makeReferralForLab(lekar, zdravstveniKarton, zdravstvenaUstanovaKojaSalje,
                zdravstvenaUstanovaKojaPrima, kadJeUzetMaterijal, klinickaDijagnoza, tipPregleda, potpisLekara, pecat);
    }
}
