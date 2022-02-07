package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.sme.SmePortalDTO;
import com.zatca.lookups.entity.configuration.sme.*;
import com.zatca.lookups.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SmePortalService {

    @Autowired
    private SmePortalRepo smePortalRepo;

    @Autowired
    private BufferPeriodCryptographicIdRevocationRepo bufferPeriodCryptographicIdRevocationRepo;

    @Autowired
    private BufferPeriodForAccessRenewalRepo bufferPeriodForAccessRenewalRepo;

    @Autowired
    private BufferPeriodForAccessRevocationRepo bufferPeriodForAccessRevocationRepo;

    @Autowired
    private InvoiceLimitRepo invoiceLimitRepo;

    @Autowired
    private WhitelistImportFrequencyRepo whitelistImportFrequencyRepo;

    public void saveSmePortalConfig(SmePortalDTO request) {
        BufferPeriodCryptographicIdRevocation bufferPeriodCryptographicIdRevocation = new BufferPeriodCryptographicIdRevocation(
                request.getBufferPeriodCryptographicIdRevocation());
        BufferPeriodForAccessRenewal bufferPeriodForAccessRenewal = new BufferPeriodForAccessRenewal(request.getBufferPeriodForAccessRenewal());
        BufferPeriodForAccessRevocation bufferPeriodForAccessRevocation = new BufferPeriodForAccessRevocation(request.getBufferPeriodForAccessRevocation());
        InvoiceLimit invoiceLimit = new InvoiceLimit(request.getInvoiceLimit());
        WhitelistImportFrequency whitelistImportFrequency = new WhitelistImportFrequency(request.getWhitelistImportFrequency());

        SmePortal smePortal = new SmePortal();
        smePortal.setBufferPeriodForAccessRenewal(bufferPeriodForAccessRenewal);
        smePortal.setBufferPeriodCryptographicIdRevocation(bufferPeriodCryptographicIdRevocation);
        smePortal.setBufferPeriodForAccessRevocation(bufferPeriodForAccessRevocation);
        smePortal.setInvoiceLimit(invoiceLimit);
        smePortal.setWhitelistImportFrequency(whitelistImportFrequency);
        smePortal.setMaxNumOfDocsDisplayedPerPage(request.getMaxNumOfDocsDisplayedPerPage());

        try {
            bufferPeriodCryptographicIdRevocationRepo.save(bufferPeriodCryptographicIdRevocation);
            bufferPeriodForAccessRenewalRepo.save(bufferPeriodForAccessRenewal);
            bufferPeriodForAccessRevocationRepo.save(bufferPeriodForAccessRevocation);
            invoiceLimitRepo.save(invoiceLimit);
            whitelistImportFrequencyRepo.save(whitelistImportFrequency);
            smePortalRepo.save(smePortal);
            log.info("SME Portal Entity: " + smePortal.toString());

        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }
}
