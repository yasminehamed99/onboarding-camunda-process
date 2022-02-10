package com.zatca.lookups.api.v1.dto.onboarding;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class NumOfOtpDTO {

    @Min(value = 0, message = "Max Num Of Otp Multi Devices can't be less than zero")
    private long maxNumOfOtpMultiDevices;
    @Min(value = 0, message = "Max Num Of Otp Displayed can't be less than zero")
    private long maxNumOfOtpDisplayed;

}
