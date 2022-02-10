package com.zatca.lookups.api.v1;

import com.zatca.lookups.api.v1.dto.AdminConfigDTO;
import com.zatca.lookups.api.v1.dto.TaxpayerVatDTO;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/lookups/v1")
@Validated
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

    @Autowired
    private ErrorService errorService;

    @Autowired
    private TaxpayerVatService taxpayerVatService;

    @Autowired
    private AdminConfigService adminConfigService;

    @Autowired
    private ClearanceStatusService clearanceStatusService;

    @GetMapping("/search/errorCode")
    public ResponseEntity<ErrorDTO> searchByErrorCode(@RequestHeader("Error-Code") String errorCode, @RequestHeader("Accept-Language") String language) {

        // TODO: get error by code
        ErrorDTO error = errorService.findErrorByCode(errorCode);

        return ResponseEntity.ok(error);
    }

    @GetMapping("/search/keyword")
    public ErrorDTO searchByKeyword(@RequestHeader("Keyword") String keyword, @RequestHeader("Accept-Language") String language) {

        ErrorDTO error = new ErrorDTO();
        // TODO: get error by keyword
        return error;
    }

    @PostMapping("/saveVat")
    public ResponseEntity<String> changeStatus(@Valid @RequestBody TaxpayerVatDTO request) {
        // TODO: get information by vat number and let user change status
        taxpayerVatService.saveVAT(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("VAT Saved Successfully");
    }

    @PostMapping("/showPageContent")
    public void showPage(@RequestHeader("Page-Name") String pageName) {

    }


    @PutMapping("/save")
    public ResponseEntity<String> update(@Valid @RequestBody AdminConfigDTO request) {
        adminConfigService.updateConfigurations(request);
        return ResponseEntity.ok("Updated Successfully");
    }

    @GetMapping("/save")
    public ResponseEntity<AdminConfigDTO> find() {
        AdminConfigDTO dto = adminConfigService.findConfigurations();

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/getClearanceStatus")
    public ResponseEntity<String> getClearanceStatus() {

        String status = clearanceStatusService.findClearanceStatus();
        return ResponseEntity.ok(status);
    }

    @GetMapping("/getVatNumbers")
    public ResponseEntity<List<TaxpayerVatDTO>> getVat() {
        List<TaxpayerVatDTO> vatNumbers = taxpayerVatService.findVatNumbers();
        return ResponseEntity.ok(vatNumbers);
    }
}
