package com.zatca.lookups.api.v1.dto.cms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;

@Data
public class CmsDto {
    @Valid
    public Sandbox sandbox;
    @Valid
    public EInvoicing einvoicing;
    @Valid
    private Fatoora fatoora;
}
