package com.zatca.lookups.api.v1.dto;

import lombok.Data;

@Data
public class ClearanceDTO {

    private String vat;
    private VatStatus clearanceStatus;
}
