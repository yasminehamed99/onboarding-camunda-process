package com.zatca.lookups.api.v1.dto.invoiceMatchingReports;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class InvoiceMatchingReportsDTO {

    private Long id;
    @Valid
    private TwoWayClearanceDTO twoWayClearance;
    @Valid
    private TwoWayClearanceDTO selfBilled;

}
