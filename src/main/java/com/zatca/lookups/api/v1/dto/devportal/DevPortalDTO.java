package com.zatca.lookups.api.v1.dto.devportal;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class DevPortalDTO {

//    private Long id;
    @Valid
    private PasswordDTO password;
    @Valid
    private VerificationLinksValidityPeriodDTO verificationLinksValidityPeriod;
    @Valid
    private AccountLockoutDTO accountLock;

}
