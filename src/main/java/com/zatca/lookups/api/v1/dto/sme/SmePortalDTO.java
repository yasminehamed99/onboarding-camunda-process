package com.zatca.lookups.api.v1.dto.sme;

import lombok.Data;

import javax.validation.Valid;

@Data
public class SmePortalDTO {

    public SmePortalDTO() {
        invoicesLimit = new InvoiceLimitDTO();
        smeWhiteListImportFreq = new WhitelistImportFrequencyDTO();
        bufferedPeriodForAccessRenew = new BufferPeriodForAccessRenewalDTO();
        bufferedPeriodForAccessRevocation = new BufferPeriodForAccessRevocationDTO();
        viewList = new ViewListDTO();
        bufferedPeriodForCSIDRevocationOnceEGSIsOnboarding = new BufferPeriodCryptographicIdRevocationDTO();
    }

//    private Long id;
    @Valid
    private InvoiceLimitDTO invoicesLimit;
    @Valid
    private WhitelistImportFrequencyDTO smeWhiteListImportFreq;
    @Valid
    private BufferPeriodForAccessRevocationDTO bufferedPeriodForAccessRevocation;
    @Valid
    private ViewListDTO viewList;
//    private long maxNumOfDocsDisplayedPerPage;
    @Valid
    private BufferPeriodForAccessRenewalDTO bufferedPeriodForAccessRenew;
    @Valid
    private BufferPeriodCryptographicIdRevocationDTO bufferedPeriodForCSIDRevocationOnceEGSIsOnboarding;
}
