package com.zatca.lookups.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClearanceStatusDto {

    @JsonProperty("oneWayClearance")
    private OneWayClearanceDto oneWayClearance;
    @JsonProperty("twoWayClearance")
    private TwoWayClearanceDto twoWayClearance;
    @JsonProperty("selfBilling")
    private TwoWayClearanceDto selfBilling;
}
