package com.zatca.lookups.entity.configuration;

import lombok.Data;

@Data
public class ClearanceDTO {

    private String vat;
    private VatStatus clearanceStatus;
}
