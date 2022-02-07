package com.zatca.lookups.api.v1.dto.devportal;

import lombok.Data;

@Data
public class DevPortalDTO {
    private PasswordDTO password;
    private VerificationLinksValidityPeriodDTO verificationLinksValidityPeriod;
    private AccountLockoutDTO accountLockout;

}
