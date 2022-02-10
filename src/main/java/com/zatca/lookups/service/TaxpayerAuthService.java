package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.taxpayerAuthorisation.TaxpayerAuthorisationDTO;
import com.zatca.lookups.entity.configuration.taxpayerAuthorisation.Portal;
import com.zatca.lookups.entity.configuration.taxpayerAuthorisation.TaxpayerAuthorisation;
import com.zatca.lookups.exception.NotFoundBusinessException;
import com.zatca.lookups.repository.PortalRepo;
import com.zatca.lookups.repository.TaxpayerAuthorisationRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
public class TaxpayerAuthService {

    @Autowired
    private TaxpayerAuthorisationRepo taxpayerAuthorisationRepo;

    @Autowired
    private PortalRepo portalRepo;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void saveTaxpayerAuthConfig(TaxpayerAuthorisationDTO request) {

        Portal smePortal = new Portal(request.getSmePortal());
        Portal einvoicingPortal = new Portal(request.getEInvoicesPortal());

        TaxpayerAuthorisation taxpayerAuthorisation = new TaxpayerAuthorisation();
        taxpayerAuthorisation.setSmePortal(smePortal);
        taxpayerAuthorisation.setEinvoicingPortal(einvoicingPortal);

        try {
//            portalRepo.save(smePortal);
//            portalRepo.save(einvoicingPortal);
            taxpayerAuthorisationRepo.save(taxpayerAuthorisation);
            log.info("Taxpayer Authorisation: " + taxpayerAuthorisation);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void updateTaxpayerAuthConfig(TaxpayerAuthorisationDTO request) {
        taxpayerAuthorisationRepo.deleteAll();
        saveTaxpayerAuthConfig(request);
    }

    public TaxpayerAuthorisationDTO findConfigs() {
        TaxpayerAuthorisation config = null;
        try {
            config = taxpayerAuthorisationRepo.findAll().get(0);
        } catch (Exception e) {
            throw new NotFoundBusinessException("No Configs Found");
        }

        TaxpayerAuthorisationDTO dto = new TaxpayerAuthorisationDTO();
        dto.getSmePortal().setTimePeriod(config.getSmePortal().getTimePeriod());
        dto.getSmePortal().setValue(config.getSmePortal().getValue());
        dto.getSmePortal().setAuthorisedStatus(config.getSmePortal().getAuthorisedStatus());
        dto.getSmePortal().setAuthorisedStatusUntilBufferPeriodEnd(config.getSmePortal().getAuthorisedStatusUntilBufferPeriodEnd());

        dto.getEInvoicesPortal().setTimePeriod(config.getEinvoicingPortal().getTimePeriod());
        dto.getEInvoicesPortal().setValue(config.getEinvoicingPortal().getValue());
        dto.getEInvoicesPortal().setAuthorisedStatus(config.getEinvoicingPortal().getAuthorisedStatus());
        dto.getEInvoicesPortal().setAuthorisedStatusUntilBufferPeriodEnd(config.getEinvoicingPortal().getAuthorisedStatusUntilBufferPeriodEnd());

        return dto;
    }
}
