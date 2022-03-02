package com.zatca.lookups.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TwoWayClearanceVatDto {

    @JsonProperty("vatNumber")
    private String vatNumber;
    @JsonProperty("sellerAcceptanceStatus")
    private String sellerAcceptanceStatus;
    @JsonProperty("invoiceMatchingReportsStatus")
    private String invoiceMatchingReportsStatus;
}
