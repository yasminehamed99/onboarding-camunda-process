package com.zatca.lookups.api.v1.dto.invoiceMatchingReports;

import lombok.Data;

@Data
public class TwoWayClearanceDTO {
    
    private long lagBetweenEndAndGenerationInMonths;
    private long lagBetweenEndAndGenerationInDays;
    private long maxPeriodOfMatchingReports;
    private long maxHistoricalDataForMatchingReports;

}
