package com.svj.zis.service;

import com.svj.zis.model.Lekar;
import com.svj.zis.model.ZdravstveniKarton;
import com.svj.zis.repository.ReferralForSpecialistExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferralForSpecialistExaminationServiceImpl implements ReferralForSpecialistExaminationService {

    @Autowired
    private ReferralForSpecialistExaminationRepository referralForSpecialistExaminationRepository;


    @Override
    public String getReferralsForSpecialistExamination(String numberOfHeathCard) throws Exception {
        return referralForSpecialistExaminationRepository.getReferralsForSpecialistExamination(numberOfHeathCard);
    }

    @Override
    public String getReferralForSpecialistExamination(String id) throws Exception {
        return referralForSpecialistExaminationRepository.getReferralForSpecialistExamination(id);
    }

    @Override
    public void makeReferralForSpecExamination(Lekar lekar, ZdravstveniKarton zdravstveniKarton,
                                               String zdravstvenaUstanovaKojaSalje, String zdravstvenaUstanovaKojaPrima,
                                               Lekar specijalista, String potpisLekara, String pecat) throws Exception {
        referralForSpecialistExaminationRepository.makeReferralForSpecExamination(lekar, zdravstveniKarton,
                zdravstvenaUstanovaKojaSalje, zdravstvenaUstanovaKojaPrima, specijalista, potpisLekara, pecat);
    }
}
