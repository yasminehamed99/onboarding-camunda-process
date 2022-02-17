package com.zatca.lookups.api.v1.dto;

import lombok.Data;

@Data
public class ClearanceStatusDTO {
    private OneWayClearanceDTO oneWayClearance;
    private twoWayClearanceDTO twoWayClearance;
    private SelfBillingClearanceDTO selfBillingClearance;
}