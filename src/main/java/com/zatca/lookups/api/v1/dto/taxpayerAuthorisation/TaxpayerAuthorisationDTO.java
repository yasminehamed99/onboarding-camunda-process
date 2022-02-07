package com.zatca.lookups.api.v1.dto.taxpayerAuthorisation;

import lombok.Data;

@Data
public class TaxpayerAuthorisationDTO {

    private PortalDTO einvoicingPortal;
    private PortalDTO smePortal;
}
