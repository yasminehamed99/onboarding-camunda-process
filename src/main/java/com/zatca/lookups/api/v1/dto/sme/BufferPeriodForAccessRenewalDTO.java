package com.zatca.lookups.api.v1.dto.sme;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class BufferPeriodForAccessRenewalDTO {

    @Min(value = 0, message = "value can't be less than zero")
    private long value;
    @NotBlank(message = "Time Period can't be empty")
    private String timePeriod;
}
