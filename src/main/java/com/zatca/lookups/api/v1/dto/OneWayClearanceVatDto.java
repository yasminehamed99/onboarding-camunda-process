package com.zatca.lookups.api.v1.dto;

import lombok.Data;

@Data
public class OneWayClearanceVatDto {

    private String vatNumber;
    private String clearanceStatus;
}
