package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.sme.SmePortalDTO;
import com.zatca.lookups.entity.configuration.sme.*;
import com.zatca.lookups.exception.NotFoundBusinessException;
import com.zatca.lookups.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


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

    @Transactional(propagation = Propagation.SUPPORTS)
    public void saveSmePortalConfig(SmePortalDTO request) {
        BufferPeriodCryptographicIdRevocation bufferPeriodCryptographicIdRevocation = new BufferPeriodCryptographicIdRevocation(
                request.getBufferedPeriodForCSIDRevocationOnceEGSIsOnboarding());
        BufferPeriodForAccessRenewal bufferPeriodForAccessRenewal = new BufferPeriodForAccessRenewal(request.getBufferedPeriodForAccessRenew());
        BufferPeriodForAccessRevocation bufferPeriodForAccessRevocation = new BufferPeriodForAccessRevocation(request.getBufferedPeriodForAccessRevocation());
        InvoiceLimit invoiceLimit = new InvoiceLimit(request.getInvoicesLimit());
        WhitelistImportFrequency whitelistImportFrequency = new WhitelistImportFrequency(request.getSmeWhiteListImportFreq());

        SmePortal smePortal = new SmePortal();
        smePortal.setBufferedPeriodForAccessRenew(bufferPeriodForAccessRenewal);
        smePortal.setBufferedPeriodForCSIDRevocationOnceEGSIsOnboarding(bufferPeriodCryptographicIdRevocation);
        smePortal.setBufferedPeriodForAccessRevocation(bufferPeriodForAccessRevocation);
        smePortal.setInvoicesLimit(invoiceLimit);
        smePortal.setSmeWhiteListImportFreq(whitelistImportFrequency);
        smePortal.setMaxNumOfDocsDisplayedPerPage(request.getViewList().getMaxNumberDocPerPage());

        try {
//            bufferPeriodCryptographicIdRevocationRepo.save(bufferPeriodCryptographicIdRevocation);
//            bufferPeriodForAccessRenewalRepo.save(bufferPeriodForAccessRenewal);
//            bufferPeriodForAccessRevocationRepo.save(bufferPeriodForAccessRevocation);
//            invoiceLimitRepo.save(invoiceLimit);
//            whitelistImportFrequencyRepo.save(whitelistImportFrequency);
            smePortalRepo.save(smePortal);
            log.info("SME Portal Entity: " + smePortal.toString());

        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void updateSmePortalConfig(SmePortalDTO request) {
        smePortalRepo.deleteAll();
        saveSmePortalConfig(request);

    }

    public SmePortalDTO findConfigs() {
        SmePortal config = null;
        try {
            config = smePortalRepo.findAll().get(0);
        } catch (Exception e) {
            throw new NotFoundBusinessException("No Configs Found");
        }

        SmePortalDTO dto = new SmePortalDTO();
        dto.getBufferedPeriodForAccessRenew().setTimePeriod(config.getBufferedPeriodForAccessRenew().getTimePeriod());
        dto.getBufferedPeriodForAccessRenew().setValue(config.getBufferedPeriodForAccessRenew().getValue());
        dto.getBufferedPeriodForAccessRevocation().setTimePeriod(config.getBufferedPeriodForAccessRevocation().getTimePeriod());
        dto.getBufferedPeriodForAccessRevocation().setValue(config.getBufferedPeriodForAccessRevocation().getValue());
        dto.getBufferedPeriodForCSIDRevocationOnceEGSIsOnboarding().setTimePeriod(config.getBufferedPeriodForCSIDRevocationOnceEGSIsOnboarding().getTimePeriod());
        dto.getBufferedPeriodForCSIDRevocationOnceEGSIsOnboarding().setValue(config.getBufferedPeriodForCSIDRevocationOnceEGSIsOnboarding().getValue());
        dto.getInvoicesLimit().setNumberOfInvoices(config.getInvoicesLimit().getNumberOfInvoices());
        dto.getInvoicesLimit().setValue(config.getInvoicesLimit().getValue());
        dto.getInvoicesLimit().setTimePeriod(config.getInvoicesLimit().getTimePeriod());
        dto.getViewList().setMaxNumberDocPerPage(config.getMaxNumOfDocsDisplayedPerPage());
        dto.getSmeWhiteListImportFreq().setTimePeriod(config.getSmeWhiteListImportFreq().getTimePeriod());
        dto.getSmeWhiteListImportFreq().setValue(config.getSmeWhiteListImportFreq().getValue());
        return dto;
    }
}
