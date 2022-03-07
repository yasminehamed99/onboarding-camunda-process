package com.zatca.lookups.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;

@Data
public class ClearanceStatusDto {

    @JsonProperty("oneWayClearance")
    @Valid
    private OneWayClearanceDto oneWayClearance;
    @JsonProperty("twoWayClearance")
    @Valid
    private TwoWayClearanceDto twoWayClearance;
    @JsonProperty("selfBilling")
    @Valid
    private TwoWayClearanceDto selfBilling;
}
