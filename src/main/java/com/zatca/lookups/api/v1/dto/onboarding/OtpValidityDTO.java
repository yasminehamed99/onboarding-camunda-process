package com.zatca.lookups.api.v1.dto.onboarding;

import lombok.Data;

@Data
public class OtpValidityDTO {

    private long value;
    private String timePeriod;
}
