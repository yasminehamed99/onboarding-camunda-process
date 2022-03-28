package com.zatca.lookups.api.v1.dto.cms;

import com.zatca.lookups.api.v1.dto.annotations.DataProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EInvoiceSpecifications {
    @NotNull(message = "block1 field is required")
    @DataProperty
    public String block1;
    @NotNull(message = "block1Ar field is required")
    @DataProperty
    public String block1Ar;
    @NotNull(message = "xmlStandard field is required")
    public String xmlStandard;
    @NotNull(message = "securityStandard field is required")
    public String securityStandard;
    @NotNull(message = "dataDictionary field is required")
    public String dataDictionary;
}
