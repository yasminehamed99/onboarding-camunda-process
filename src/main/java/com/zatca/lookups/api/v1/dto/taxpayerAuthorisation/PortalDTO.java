package com.zatca.lookups.api.v1.dto.taxpayerAuthorisation;

import lombok.Data;

@Data
public class PortalDTO {
    
    private AuthorisedStatus authorisedStatus;
    private AuthorisedStatusUntilBufferPeriodEnd authorisedStatusUntilBufferPeriodEnd;
    private long value;
    private String timePeriod;
}
