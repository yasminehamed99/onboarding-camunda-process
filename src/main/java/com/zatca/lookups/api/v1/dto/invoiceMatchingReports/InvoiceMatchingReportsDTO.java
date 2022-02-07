package com.zatca.lookups.api.v1.dto.invoiceMatchingReports;

import lombok.Data;

// TODO: Ask nedal about it
@Data
public class InvoiceMatchingReportsDTO {

    private TwoWayClearanceDTO twoWayClearance;
    private TwoWayClearanceDTO selfBilled;

}
