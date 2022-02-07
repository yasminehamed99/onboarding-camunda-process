package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.onboarding.OnboardingDTO;
import com.zatca.lookups.entity.configuration.onboarding.NumOfOtp;
import com.zatca.lookups.entity.configuration.onboarding.Onboarding;
import com.zatca.lookups.entity.configuration.onboarding.OtpValidity;
import com.zatca.lookups.repository.NumOfOtpRepo;
import com.zatca.lookups.repository.OnboardingRepo;
import com.zatca.lookups.repository.OtpValidityRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OnboardingService {

    @Autowired
    private OnboardingRepo onboardingRepo;

    @Autowired
    private NumOfOtpRepo numOfOtpRepo;

    @Autowired
    private OtpValidityRepo otpValidityRepo;

    public void saveOnboardingConfig(OnboardingDTO request) {

        NumOfOtp numOfOtp = new NumOfOtp(request.getNumOfOtp());
        OtpValidity otpValidity = new OtpValidity(request.getOtpValidity());
        Onboarding onboarding = new Onboarding();
        onboarding.setMaxNumOfDocsDisplayedPerPage(request.getMaxNumOfDocsDisplayedPerPage());
        onboarding.setOtpLength(request.getOtpLength());
        onboarding.setNumOfOtp(numOfOtp);
        onboarding.setOtpValidity(otpValidity);
        try {
            numOfOtpRepo.save(numOfOtp);
            otpValidityRepo.save(otpValidity);
            onboardingRepo.save(onboarding);
            log.info("Onboarding Entity: " + onboarding);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }

    }
}
