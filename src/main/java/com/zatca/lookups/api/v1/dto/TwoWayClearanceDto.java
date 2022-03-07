package com.zatca.lookups.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class TwoWayClearanceDto {

    @JsonProperty("clearanceStatus")
    @NotBlank(message = "clearance status can't be empty or null")
    private String clearanceStatus;
    @JsonProperty("vatNumbersList")
    private List<TwoWayClearanceVatDto> vatNumbersList;

}
