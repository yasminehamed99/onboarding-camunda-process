package com.zatca.lookups.api.v1.dto.devportal;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class VerificationLinksValidityPeriodDTO {

    @Min(value = 1, message = "value can't be less than 1")
    private long value;
    @NotBlank(message = "Time Period can't equals zero or null")
    private String timePeriod;
}
