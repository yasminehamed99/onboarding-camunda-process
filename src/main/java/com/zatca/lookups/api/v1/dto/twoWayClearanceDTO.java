package com.zatca.lookups.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class twoWayClearanceDTO {
    private String sellerAcceptanceStatus;
    @JsonProperty("invoiceMatchingReportsStatus")
    private String invoiceMatchingReportsStatus;
}
