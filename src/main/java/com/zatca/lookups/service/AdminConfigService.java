package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.AdminConfigDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j

public class AdminConfigService {

    @Autowired
    private DevPortalService devPortalService;

    @Autowired
    private SmePortalService smePortalService;

    @Autowired
    private OnboardingService onboardingService;

    @Autowired
    private TaxpayerAuthService taxpayerAuthService;

    @Autowired
    private InvoiceMatchingReportsService invoiceMatchingReportsService;

    @Autowired
    private TaxpayerDataService taxpayerDataService;

    @Autowired
    private NotificationService notificationService;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveConfigs(AdminConfigDTO request){
        devPortalService.saveDevPortalConfig(request.getDeveloperPortal());
        invoiceMatchingReportsService.saveInvoiceMatchingReportsConfig(request.getInvoiceMatchingBatches());
        smePortalService.saveSmePortalConfig(request.getSmePortal());
        onboardingService.saveOnboardingConfig(request.getOnBoarding());
        taxpayerAuthService.saveTaxpayerAuthConfig(request.getTaxpayerAuthrization());
        taxpayerDataService.saveTaxpayerDataConfig(request.getTaxpayerData());
        notificationService.saveNotificationConfig(request.getNotifications());
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateConfigurations(AdminConfigDTO request) {
        devPortalService.updateDevPortalConfig(request.getDeveloperPortal());
        invoiceMatchingReportsService.updateInvoiceMatchingReportsConfig(request.getInvoiceMatchingBatches());
        smePortalService.updateSmePortalConfig(request.getSmePortal());
        onboardingService.updateOnboardingConfig(request.getOnBoarding());
        taxpayerAuthService.updateTaxpayerAuthConfig(request.getTaxpayerAuthrization());
        taxpayerDataService.updateTaxpayerDataAuthConfig(request.getTaxpayerData());
        notificationService.updateNotificationConfig(request.getNotifications());

    }

    public AdminConfigDTO findConfigurations() {
        AdminConfigDTO dto = new AdminConfigDTO();
        dto.setDeveloperPortal(devPortalService.findConfigs());
        dto.setSmePortal(smePortalService.findConfigs());
        dto.setOnBoarding(onboardingService.findConfigs());
        dto.setTaxpayerAuthrization(taxpayerAuthService.findConfigs());
        dto.setTaxpayerData(taxpayerDataService.findConfigs());
        dto.setNotifications(notificationService.findConfigs());
        return dto;
    }
}
