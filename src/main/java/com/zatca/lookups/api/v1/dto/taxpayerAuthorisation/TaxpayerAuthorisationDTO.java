package com.zatca.lookups.api.v1.dto.taxpayerAuthorisation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;

@Data
public class TaxpayerAuthorisationDTO {

    public TaxpayerAuthorisationDTO() {
        eInvoicesPortal = new PortalDTO();
        smePortal = new PortalDTO();
    }

//    private Long id;
    @Valid
    @JsonProperty("eInvoicesPortal")
    private PortalDTO eInvoicesPortal;
    @Valid
    private PortalDTO smePortal;
}
