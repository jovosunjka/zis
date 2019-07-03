package com.svj.zis;

import com.svj.zis.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SaveXmlFilesInExistDB {

    @Autowired
    private DoctorReceiptRepository doctorReceiptRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private HealthCardRepository healthCardRepository;

    @Autowired
    private NurseRepository nurseRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ReferralForLabRepository referralForLabRepository;

    @Autowired
    private ReferralForSpecialistExaminationRepository referralForSpecialistExaminationRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private MedicamentRepository medicamentRepository;


    /**
     * Prilikom pokretanja aplikacije, bice upisani svi entiteti iz fajlova koji se nalaze u /resources/xml folderu
     * */
    @EventListener(ApplicationReadyEvent.class)
    private void saveXmlFiles() {
        try {
            doctorReceiptRepository.saveAll();
            doctorRepository.saveAll();
            healthCardRepository.saveAll();
            nurseRepository.saveAll();
            patientRepository.saveAll();
            referralForLabRepository.saveAll();
            referralForSpecialistExaminationRepository.saveAll();
            reviewRepository.saveAll();
            userRepository.saveAll();
            reportRepository.saveAll();
            medicamentRepository.saveAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
