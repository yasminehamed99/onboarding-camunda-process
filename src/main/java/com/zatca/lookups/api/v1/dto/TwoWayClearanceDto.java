package com.zatca.lookups.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TwoWayClearanceDto {

    @JsonProperty("clearanceStatus")
    private String clearanceStatus;
    @JsonProperty("vatNumbersList")
    private List<TwoWayClearanceVatDto> vatNumbersList;

}
