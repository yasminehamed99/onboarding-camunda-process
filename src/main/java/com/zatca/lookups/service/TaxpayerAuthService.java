package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.taxpayerAuthorisation.TaxpayerAuthorisationDTO;
import com.zatca.lookups.entity.configuration.taxpayerAuthorisation.Portal;
import com.zatca.lookups.entity.configuration.taxpayerAuthorisation.TaxpayerAuthorisation;
import com.zatca.lookups.repository.PortalRepo;
import com.zatca.lookups.repository.TaxpayerAuthorisationRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaxpayerAuthService {

    @Autowired
    private TaxpayerAuthorisationRepo taxpayerAuthorisationRepo;

    @Autowired
    private PortalRepo portalRepo;

    public void saveTaxpayerAuthConfig(TaxpayerAuthorisationDTO request) {

        Portal smePortal = new Portal(request.getSmePortal());
        Portal einvoicingPortal = new Portal(request.getEinvoicingPortal());

        TaxpayerAuthorisation taxpayerAuthorisation = new TaxpayerAuthorisation();
        taxpayerAuthorisation.setSmePortal(smePortal);
        taxpayerAuthorisation.setEinvoicingPortal(einvoicingPortal);

        try {
            portalRepo.save(smePortal);
            portalRepo.save(einvoicingPortal);
            taxpayerAuthorisationRepo.save(taxpayerAuthorisation);
            log.info("Taxpayer Authorisation: " + taxpayerAuthorisation);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }
}
