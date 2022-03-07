package com.zatca.lookups.api.v1.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class OneWayClearanceDto {

    @NotBlank(message = "OneWay clearance status can't be empty or null")
    private String oneWayClearanceStatus;
    private List<OneWayClearanceVatDto> vatNumbersList;
}
