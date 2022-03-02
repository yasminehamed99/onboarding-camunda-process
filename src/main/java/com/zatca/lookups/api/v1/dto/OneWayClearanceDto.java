package com.zatca.lookups.api.v1.dto;

import lombok.Data;

import java.util.List;

@Data
public class OneWayClearanceDto {

    private String oneWayClearanceStatus;
    private List<OneWayClearanceVatDto> vatNumbersList;
}
