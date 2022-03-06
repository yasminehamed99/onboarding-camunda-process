package com.zatca.lookups.api.v1.dto.taxpayerAuthorisation;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PortalDTO {

    @NotNull(message = "Authorised Status can't be null or empty")
    private String authorisedStatus;
    @NotNull(message = "Authorised Status Until Buffer Period End can't be null or empty")
    private String authorisedStatusUntilBufferPeriodEnd;
    @Min(value = 0, message = "value can't be less than zero")
    private long value;
    @NotBlank(message = "Time Period can't be empty")
    private String timePeriod;
}
