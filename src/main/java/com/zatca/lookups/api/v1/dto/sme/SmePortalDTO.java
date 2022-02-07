package com.zatca.lookups.api.v1.dto.sme;

import lombok.Data;

@Data
public class SmePortalDTO {

    private InvoiceLimitDTO invoiceLimit;
    private WhitelistImportFrequencyDTO whitelistImportFrequency;
    private BufferPeriodForAccessRevocationDTO bufferPeriodForAccessRevocation;
//    private ViewListDTO viewList;
    private long maxNumOfDocsDisplayedPerPage;
    private BufferPeriodForAccessRenewalDTO bufferPeriodForAccessRenewal;
    private BufferPeriodCryptographicIdRevocationDTO bufferPeriodCryptographicIdRevocation;
}
