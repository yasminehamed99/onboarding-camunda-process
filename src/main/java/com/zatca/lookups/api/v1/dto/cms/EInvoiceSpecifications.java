package com.zatca.lookups.api.v1.dto.cms;

import javax.validation.constraints.NotBlank;

public class EInvoiceSpecifications {
    @NotBlank(message = "This field is required")
    public String block1;
    @NotBlank(message = "This field is required")
    public String block1Ar;
    @NotBlank(message = "This field is required")
    public String xmlStandard;
    @NotBlank(message = "This field is required")
    public String securityStandard;
    @NotBlank(message = "This field is required")
    public String dataDictionary;
}
