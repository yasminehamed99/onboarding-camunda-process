package com.zatca.lookups.api.v1.dto;

import lombok.Data;

@Data
public class ClearanceStatus {
    private OneWayClearance oneWayClearance;
    private com.zatca.lookups.api.v1.dto.twoWayClearance twoWayClearance;
    private SelfBillingClearanceDTO selfBillingClearance;
}