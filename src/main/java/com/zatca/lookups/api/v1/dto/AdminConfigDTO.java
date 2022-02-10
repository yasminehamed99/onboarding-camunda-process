package com.zatca.lookups.api.v1.dto;

import com.zatca.lookups.api.v1.dto.devportal.DevPortalDTO;
import com.zatca.lookups.api.v1.dto.invoiceMatchingReports.InvoiceMatchingReportsDTO;
import com.zatca.lookups.api.v1.dto.notification.NotificationDTO;
import com.zatca.lookups.api.v1.dto.onboarding.OnboardingDTO;
import com.zatca.lookups.api.v1.dto.sme.SmePortalDTO;
import com.zatca.lookups.api.v1.dto.taxpayerAuthorisation.TaxpayerAuthorisationDTO;
import com.zatca.lookups.api.v1.dto.taxpayerData.TaxpayerDataDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminConfigDTO {
    @Valid
    private DevPortalDTO developerPortal;
    @Valid
    private InvoiceMatchingReportsDTO invoiceMatchingBatches;
    @Valid
    private SmePortalDTO smePortal;
    @Valid
    private OnboardingDTO onBoarding;
    @Valid
    private TaxpayerAuthorisationDTO taxpayerAuthrization;
    @Valid
    private TaxpayerDataDTO taxpayerData;
    @Valid
    private NotificationDTO notifications;
}
