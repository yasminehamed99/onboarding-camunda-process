package com.zatca.lookups.api.v1.dto.onboarding;

import com.zatca.lookups.api.v1.dto.sme.ViewListDTO;
import lombok.Data;

@Data
public class OnboardingDTO {

    private OtpValidityDTO otpValidity;
    private long otpLength;
    private NumOfOtpDTO numOfOtp;
    private long maxNumOfDocsDisplayedPerPage;

//    private ViewListDTO viewList;
}
