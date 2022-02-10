package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.onboarding.OnboardingDTO;
import com.zatca.lookups.entity.configuration.onboarding.NumOfOtp;
import com.zatca.lookups.entity.configuration.onboarding.Onboarding;
import com.zatca.lookups.entity.configuration.onboarding.OtpValidity;
import com.zatca.lookups.exception.NotFoundBusinessException;
import com.zatca.lookups.repository.NumOfOtpRepo;
import com.zatca.lookups.repository.OnboardingRepo;
import com.zatca.lookups.repository.OtpValidityRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
public class OnboardingService {

    @Autowired
    private OnboardingRepo onboardingRepo;

    @Autowired
    private NumOfOtpRepo numOfOtpRepo;

    @Autowired
    private OtpValidityRepo otpValidityRepo;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void saveOnboardingConfig(OnboardingDTO request) {

        NumOfOtp numOfOtp = new NumOfOtp(request.getNumOfOTPs());
        OtpValidity otpValidity = new OtpValidity(request.getOtpValidity());
        Onboarding onboarding = new Onboarding();
        onboarding.setMaxNumOfDocsDisplayedPerPage(request.getViewList().getMaxNumberDocPerPage());
        onboarding.setOtpLength(request.getOtpLength());
        onboarding.setNumOfOtp(numOfOtp);
        onboarding.setOtpValidity(otpValidity);
        try {
//            numOfOtpRepo.save(numOfOtp);
//            otpValidityRepo.save(otpValidity);
            onboardingRepo.save(onboarding);
            log.info("Onboarding Entity: " + onboarding);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void updateOnboardingConfig(OnboardingDTO request) {
        onboardingRepo.deleteAll();
        saveOnboardingConfig(request);
    }

    public OnboardingDTO findConfigs() {

        Onboarding config = null;
        try {
            config = onboardingRepo.findAll().get(0);
        } catch (Exception e) {
            throw new NotFoundBusinessException("No Configs Found");
        }

        OnboardingDTO dto = new OnboardingDTO();
        dto.setOtpLength(config.getOtpLength());
        dto.getOtpValidity().setValue(config.getOtpValidity().getValue());
        dto.getOtpValidity().setTimePeriod(config.getOtpValidity().getTimePeriod());
        dto.getViewList().setMaxNumberDocPerPage(config.getMaxNumOfDocsDisplayedPerPage());
        dto.getNumOfOTPs().setMaxNumOfOtpDisplayed(config.getNumOfOtp().getMaxNumOfOtpDisplayed());
        dto.getNumOfOTPs().setMaxNumOfOtpMultiDevices(config.getNumOfOtp().getMaxNumOfOtpMultiDevices());

        return dto;
    }
}
