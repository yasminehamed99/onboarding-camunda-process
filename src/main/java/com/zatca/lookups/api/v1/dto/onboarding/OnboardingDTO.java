package com.zatca.lookups.api.v1.dto.onboarding;

import com.zatca.lookups.api.v1.dto.sme.ViewListDTO;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class OnboardingDTO {

    public OnboardingDTO() {
        otpValidity = new OtpValidityDTO();
        numOfOTPs = new NumOfOtpDTO();
        viewList = new ViewListDTO();
    }

    private Long id;
    @Valid
    private OtpValidityDTO otpValidity;

    @Min(value = 3, message = "OTP Length can't be less than 3")
    @Max(value = 10, message = "OTP Length can't be greater than 10")
    private long otpLength;

    @Valid
    private NumOfOtpDTO numOfOTPs;
//    private long maxNumOfDocsDisplayedPerPage;

    @Valid
    private ViewListDTO viewList;
}
