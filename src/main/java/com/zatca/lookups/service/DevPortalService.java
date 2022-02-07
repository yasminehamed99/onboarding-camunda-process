package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.devportal.DevPortalDTO;
import com.zatca.lookups.entity.configuration.devportal.AccountLockout;
import com.zatca.lookups.entity.configuration.devportal.DevPortal;
import com.zatca.lookups.entity.configuration.devportal.Password;
import com.zatca.lookups.entity.configuration.devportal.VerificationLinksValidityPeriod;
import com.zatca.lookups.repository.AccountLockoutRepo;
import com.zatca.lookups.repository.DevPortalRepo;
import com.zatca.lookups.repository.PasswordRepo;
import com.zatca.lookups.repository.VerificationLinksValidityPeriodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevPortalService {

    @Autowired
    private DevPortalRepo devPortalRepo;

    @Autowired
    private AccountLockoutRepo accountLockoutRepo;

    @Autowired
    private PasswordRepo passwordRepo;

    @Autowired
    private VerificationLinksValidityPeriodRepo verificationLinksValidityPeriodRepo;

    public void saveDevPortalConfig(DevPortalDTO request) {

        DevPortal devPortalEntity = new DevPortal();
        AccountLockout accountLockoutEntity = new AccountLockout();
        accountLockoutEntity.setNumOfIncorrectPasswordAttempts(request.getAccountLockout().getNumOfIncorrectPasswordAttempts());
        accountLockoutEntity.setValue(request.getAccountLockout().getValue());
        accountLockoutEntity.setTimePeriod(request.getAccountLockout().getTimePeriod());

        accountLockoutRepo.save(accountLockoutEntity);
        devPortalEntity.setAccountLockout(accountLockoutEntity);

        Password passwordEntity = new Password();
        passwordEntity.setLength(request.getPassword().getLength());
        passwordEntity.setMinNumOfLowerCase(request.getPassword().getMinNumOfLowerCase());
        passwordEntity.setMinNumOfNumbers(request.getPassword().getMinNumOfNumbers());
        passwordEntity.setMinNumOfSymbols(request.getPassword().getMinNumOfSymbols());
        passwordEntity.setMinNumOfUpperCase(request.getPassword().getMinNumOfUpperCase());

        passwordRepo.save(passwordEntity);
        devPortalEntity.setPassword(passwordEntity);

        VerificationLinksValidityPeriod verificationLinksValidityPeriodEntity = new VerificationLinksValidityPeriod();
        verificationLinksValidityPeriodEntity.setTimePeriod(request.getVerificationLinksValidityPeriod().getTimePeriod());
        verificationLinksValidityPeriodEntity.setValue(request.getVerificationLinksValidityPeriod().getValue());

        verificationLinksValidityPeriodRepo.save(verificationLinksValidityPeriodEntity);
        devPortalEntity.setVerificationLinksValidityPeriod(verificationLinksValidityPeriodEntity);

        devPortalRepo.save(devPortalEntity);

    }
}
