package com.zatca.lookups.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
public class TaxpayerVatDTO {

//    @Min(value = 15, message = "VAT Number can't be less than 15 number")
//    @Max(value = 15, message = "VAT Number can't be greater than 15 number")
    @Size(min = 15, max = 15, message = "VAT Number can't be less than 15 or greater then 15 digits")
    @JsonProperty("vat")
    private String vat;
    @NotNull(message = "VAT Status can't be null or empty")
    @JsonProperty("clearanceStatus")
    private VatStatus clearanceStatus;
}
