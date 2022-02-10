package com.zatca.lookups.api.v1.dto.invoiceMatchingReports;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class TwoWayClearanceDTO {

    @Min(value = 0, message = "Lag Between End And Generation In Months can't be less than zero")
    private long lagBetweenEndAndGenerationInMonths;
    @Min(value = 0, message = "Lag Between End And Generation In Days can't be less than zero")
    private long lagBetweenEndAndGenerationInDays;
    @Min(value = 0, message = "Max Period Of Matching Reports can't be less than zero")
    private long maxPeriodOfMatchingReports;
    @Min(value = 0, message = "Max Historical Data For Matching Reports can't be less than zero")
    private long maxHistoricalDataForMatchingReports;

}
