package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.devportal.AccountLockoutDTO;
import com.zatca.lookups.api.v1.dto.devportal.DevPortalDTO;
import com.zatca.lookups.api.v1.dto.devportal.PasswordDTO;
import com.zatca.lookups.api.v1.dto.devportal.VerificationLinksValidityPeriodDTO;
import com.zatca.lookups.entity.configuration.devportal.AccountLockout;
import com.zatca.lookups.entity.configuration.devportal.DevPortal;
import com.zatca.lookups.entity.configuration.devportal.Password;
import com.zatca.lookups.entity.configuration.devportal.VerificationLinksValidityPeriod;
import com.zatca.lookups.exception.NotFoundBusinessException;
import com.zatca.lookups.repository.AccountLockoutRepo;
import com.zatca.lookups.repository.DevPortalRepo;
import com.zatca.lookups.repository.PasswordRepo;
import com.zatca.lookups.repository.VerificationLinksValidityPeriodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


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

    @Transactional(propagation = Propagation.SUPPORTS)
    public void saveDevPortalConfig(DevPortalDTO request) {

        DevPortal devPortalEntity = new DevPortal();
        AccountLockout accountLockoutEntity = new AccountLockout();
        accountLockoutEntity.setNumOfIncorrectPasswordAttempts(request.getAccountLock().getNumOfIncorrectPasswordAttemp());
        accountLockoutEntity.setValue(request.getAccountLock().getValue());
        accountLockoutEntity.setTimePeriod(request.getAccountLock().getTimePeriod());

//        accountLockoutRepo.save(accountLockoutEntity);
        devPortalEntity.setAccountLockout(accountLockoutEntity);

        Password passwordEntity = new Password();
        passwordEntity.setLength(request.getPassword().getPasswordLength());
        passwordEntity.setMinNumOfLowerCase(request.getPassword().getMinNumOfCharsLowercase());
        passwordEntity.setMinNumOfNumbers(request.getPassword().getMinNumOfNums());
        passwordEntity.setMinNumOfSymbols(request.getPassword().getMinNumOfSymbols());
        passwordEntity.setMinNumOfUpperCase(request.getPassword().getMinNumOfCharsUppercase());

//        passwordRepo.save(passwordEntity);
        devPortalEntity.setPassword(passwordEntity);

        VerificationLinksValidityPeriod verificationLinksValidityPeriodEntity = new VerificationLinksValidityPeriod();
        verificationLinksValidityPeriodEntity.setTimePeriod(request.getVerificationLinksValidityPeriod().getTimePeriod());
        verificationLinksValidityPeriodEntity.setValue(request.getVerificationLinksValidityPeriod().getValue());

//        verificationLinksValidityPeriodRepo.save(verificationLinksValidityPeriodEntity);
        devPortalEntity.setVerificationLinksValidityPeriod(verificationLinksValidityPeriodEntity);

        devPortalRepo.save(devPortalEntity);

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void updateDevPortalConfig(DevPortalDTO request) {

        devPortalRepo.deleteAll();
        saveDevPortalConfig(request);

    }

    public DevPortalDTO findConfigs() {

        DevPortal config = null;
        try {
            config = devPortalRepo.findAll().get(0);
        } catch (Exception e) {
            throw new NotFoundBusinessException("No Configs Found");
        }

        DevPortalDTO dto = new DevPortalDTO();

        PasswordDTO passwordDTO =new PasswordDTO();
        passwordDTO.setPasswordLength(config.getPassword().getLength());
        passwordDTO.setMinNumOfCharsLowercase(config.getPassword().getMinNumOfLowerCase());
        passwordDTO.setMinNumOfNums(config.getPassword().getMinNumOfNumbers());
        passwordDTO.setMinNumOfSymbols(config.getPassword().getMinNumOfSymbols());
        passwordDTO.setMinNumOfCharsUppercase(config.getPassword().getMinNumOfUpperCase());
        dto.setPassword(passwordDTO);

        AccountLockoutDTO accountLockoutDTO = new AccountLockoutDTO();
        accountLockoutDTO.setTimePeriod(config.getAccountLockout().getTimePeriod());
        accountLockoutDTO.setValue(config.getAccountLockout().getValue());
        accountLockoutDTO.setNumOfIncorrectPasswordAttemp(config.getAccountLockout().getNumOfIncorrectPasswordAttempts());
        dto.setAccountLock(accountLockoutDTO);

        VerificationLinksValidityPeriodDTO verificationLinksValidityPeriodDTO = new VerificationLinksValidityPeriodDTO();
        verificationLinksValidityPeriodDTO.setTimePeriod(config.getVerificationLinksValidityPeriod().getTimePeriod());
        verificationLinksValidityPeriodDTO.setValue(config.getVerificationLinksValidityPeriod().getValue());
        dto.setVerificationLinksValidityPeriod(verificationLinksValidityPeriodDTO);

        return dto;

    }
}
