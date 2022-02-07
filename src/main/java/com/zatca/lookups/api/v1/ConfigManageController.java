package com.zatca.lookups.api.v1;

import com.zatca.lookups.api.v1.dto.ClearanceDTO;
import com.zatca.lookups.api.v1.dto.devportal.DevPortalDTO;
import com.zatca.lookups.api.v1.dto.errorMessages.ErrorDTO;
import com.zatca.lookups.api.v1.dto.invoiceMatchingReports.InvoiceMatchingReportsDTO;
import com.zatca.lookups.api.v1.dto.notification.NotificationDTO;
import com.zatca.lookups.api.v1.dto.onboarding.OnboardingDTO;
import com.zatca.lookups.api.v1.dto.sme.SmePortalDTO;
import com.zatca.lookups.api.v1.dto.taxpayerAuthorisation.TaxpayerAuthorisationDTO;
import com.zatca.lookups.api.v1.dto.taxpayerData.TaxpayerDataDTO;
import com.zatca.lookups.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lookups/v1")
public class ConfigManageController {

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
    @GetMapping("/search/errorCode")
    public ErrorDTO searchByErrorCode(@RequestHeader("Error-Code") String errorCode, @RequestHeader("Accept-Language") String language) {

        ErrorDTO error = new ErrorDTO();
        // TODO: get error by code
        return error;
    }

    @GetMapping("/search/keyword")
    public ErrorDTO searchByKeyword(@RequestHeader("Keyword") String keyword, @RequestHeader("Accept-Language") String language) {

        ErrorDTO error = new ErrorDTO();
        // TODO: get error by keyword
        return error;
    }

    @PostMapping("/changeStatus")
    public ClearanceDTO changeStatus(@RequestHeader("VAT-Number") String vat) {
        // TODO: get information by vat number and let user change status
        return new ClearanceDTO();
    }

    @PostMapping("/showPageContent")
    public void showPage(@RequestHeader("Page-Name") String pageName) {

    }

    @PostMapping("/saveDevPortal")
    public ResponseEntity<String> saveDevPortal(@RequestBody DevPortalDTO devPortal) {

        devPortalService.saveDevPortalConfig(devPortal);
        return ResponseEntity.status(HttpStatus.OK).body("Developer Portal configuration saved successfully");
    }

    @PostMapping("/saveSmePortal")
    public ResponseEntity<String> saveSmePortal(@RequestBody SmePortalDTO smePortal) {

        smePortalService.saveSmePortalConfig(smePortal);
        return ResponseEntity.status(HttpStatus.OK).body("SME Portal configuration saved successfully");
    }

    @PostMapping("/saveOnboarding")
    public ResponseEntity<String> saveOnboarding(@RequestBody OnboardingDTO onboarding) {

        onboardingService.saveOnboardingConfig(onboarding);
        return ResponseEntity.status(HttpStatus.OK).body("Onboarding configuration saved successfully");
    }

    @PostMapping("/saveTaxpayerAuthorisation")
    public ResponseEntity<String> saveTaxpayerAuth(@RequestBody TaxpayerAuthorisationDTO taxpayerAuthorisation) {

        taxpayerAuthService.saveTaxpayerAuthConfig(taxpayerAuthorisation);
        return ResponseEntity.status(HttpStatus.OK).body("Taxpayer Auth configuration saved successfully");
    }

    @PostMapping("/saveInvoiceMatchingReports")
    public ResponseEntity<String> saveInvoiceMatchingReports(@RequestBody InvoiceMatchingReportsDTO invoiceMatchingReportsDTO) {

        invoiceMatchingReportsService.saveInvoiceMatchingReportsConfig(invoiceMatchingReportsDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Invoice Matching Reports configuration saved successfully");
    }

    @PostMapping("/saveTaxpayerData")
    public ResponseEntity<String> saveTaxpayerData(@RequestBody TaxpayerDataDTO taxpayerDataDTO) {

        taxpayerDataService.saveTaxpayerDataConfig(taxpayerDataDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Taxpayer Data configuration saved successfully");
    }

    @PostMapping("/saveNotification")
    public ResponseEntity<String> saveNotificationConfig(@RequestBody NotificationDTO notificationDTO) {

        notificationService.saveNotificationConfig(notificationDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Notification configuration saved successfully");
    }
}
