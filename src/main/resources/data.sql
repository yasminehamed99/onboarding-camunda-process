SET IDENTITY_INSERT [dbo].[lookup] ON
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (171, N'Root-Vat-Status', NULL, N'Root-Vat-Status-Group', N'ENABLED', N'java.lang.String', NULL)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (162, N'Root-Clearance-Config', NULL, N'Root-Clearance-Config-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.ClearanceStatusDTO', NULL)
SET IDENTITY_INSERT [dbo].[lookup] OFF
SET IDENTITY_INSERT [dbo].[lookup_meta_data] ON
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (172, N'312345678900003', N'java.lang.String', N'ENABLED', 171)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (166, N'status', N'java.lang.String', N'Enabled', 163)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (167, N'sellerAcceptanceStatus', N'java.lang.String', N'Enabled', 164)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (168, N'invoiceMatchingReportsStatus', N'java.lang.String', N'Enabled', 164)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (169, N'sellerAcceptanceStatus', N'java.lang.String', N'Enabled', 165)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (170, N'invoiceMatchingReportsStatus', N'java.lang.String', N'Enabled', 165)
SET IDENTITY_INSERT [dbo].[lookup_meta_data] OFF
SET IDENTITY_INSERT [dbo].[lookup] ON
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (172, N'Root-Admin-Config', NULL, N'Root-Admin-Config-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.AdminConfigDTO', NULL)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (173, N'Root-Admin-Config-developerPortal', N'developerPortal', N'Root-Admin-Config-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.devportal.DevPortalDTO', 172)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (174, N'Root-Admin-Config-developerPortal-password', N'password', N'Root-Admin-Config-developerPortal-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.devportal.PasswordDTO', 173)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (175, N'Root-Admin-Config-developerPortal-verificationLinksValidityPeriod', N'verificationLinksValidityPeriod', N'Root-Admin-Config-developerPortal-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.devportal.VerificationLinksValidityPeriodDTO', 173)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (176, N'Root-Admin-Config-developerPortal-accountLock', N'accountLock', N'Root-Admin-Config-developerPortal-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.devportal.AccountLockoutDTO', 173)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (177, N'Root-Admin-Config-invoiceMatchingBatches', N'invoiceMatchingBatches', N'Root-Admin-Config-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.invoiceMatchingReports.InvoiceMatchingReportsDTO', 172)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (178, N'Root-Admin-Config-invoiceMatchingBatches-twoWayClearance', N'twoWayClearance', N'Root-Admin-Config-invoiceMatchingBatches-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.invoiceMatchingReports.TwoWayClearanceDTO', 177)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (179, N'Root-Admin-Config-invoiceMatchingBatches-selfBilled', N'selfBilled', N'Root-Admin-Config-invoiceMatchingBatches-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.invoiceMatchingReports.TwoWayClearanceDTO', 177)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (180, N'Root-Admin-Config-smePortal', N'smePortal', N'Root-Admin-Config-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.sme.SmePortalDTO', 172)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (181, N'Root-Admin-Config-smePortal-invoicesLimit', N'invoicesLimit', N'Root-Admin-Config-smePortal-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.sme.InvoiceLimitDTO', 180)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (182, N'Root-Admin-Config-smePortal-smeWhiteListImportFreq', N'smeWhiteListImportFreq', N'Root-Admin-Config-smePortal-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.sme.WhitelistImportFrequencyDTO', 180)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (183, N'Root-Admin-Config-smePortal-bufferedPeriodForAccessRevocation', N'bufferedPeriodForAccessRevocation', N'Root-Admin-Config-smePortal-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.sme.BufferPeriodForAccessRevocationDTO', 180)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (184, N'Root-Admin-Config-smePortal-viewList', N'viewList', N'Root-Admin-Config-smePortal-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.sme.ViewListDTO', 180)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (185, N'Root-Admin-Config-smePortal-bufferedPeriodForAccessRenew', N'bufferedPeriodForAccessRenew', N'Root-Admin-Config-smePortal-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.sme.BufferPeriodForAccessRenewalDTO', 180)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (186, N'Root-Admin-Config-smePortal-bufferedPeriodForCSIDRevocationOnceEGSIsOnboarding', N'bufferedPeriodForCSIDRevocationOnceEGSIsOnboarding', N'Root-Admin-Config-smePortal-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.sme.BufferPeriodCryptographicIdRevocationDTO', 180)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (187, N'Root-Admin-Config-onBoarding', N'onBoarding', N'Root-Admin-Config-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.onboarding.OnboardingDTO', 172)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (188, N'Root-Admin-Config-onBoarding-otpValidity', N'otpValidity', N'Root-Admin-Config-onBoarding-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.onboarding.OtpValidityDTO', 187)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (189, N'Root-Admin-Config-onBoarding-numOfOTPs', N'numOfOTPs', N'Root-Admin-Config-onBoarding-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.onboarding.NumOfOtpDTO', 187)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (190, N'Root-Admin-Config-onBoarding-viewList', N'viewList', N'Root-Admin-Config-onBoarding-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.sme.ViewListDTO', 187)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (191, N'Root-Admin-Config-taxpayerAuthrization', N'taxpayerAuthrization', N'Root-Admin-Config-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.taxpayerAuthorisation.TaxpayerAuthorisationDTO', 172)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (192, N'Root-Admin-Config-taxpayerAuthrization-eInvoicesPortal', N'eInvoicesPortal', N'Root-Admin-Config-taxpayerAuthrization-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.taxpayerAuthorisation.PortalDTO', 191)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (193, N'Root-Admin-Config-taxpayerAuthrization-smePortal', N'smePortal', N'Root-Admin-Config-taxpayerAuthrization-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.taxpayerAuthorisation.PortalDTO', 191)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (194, N'Root-Admin-Config-taxpayerData', N'taxpayerData', N'Root-Admin-Config-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.taxpayerData.TaxpayerDataDTO', 172)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (195, N'Root-Admin-Config-taxpayerData-importFreqZatcaDatawareHours', N'importFreqZatcaDatawareHours', N'Root-Admin-Config-taxpayerData-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.taxpayerData.ImportFreqZatcaDatawareHours', 194)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (196, N'Root-Admin-Config-notifications', N'notifications', N'Root-Admin-Config-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.notification.NotificationDTO', 172)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (197, N'Root-Admin-Config-notifications-smePortal', N'smePortal', N'Root-Admin-Config-notifications-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.notification.NotificationInfoDTO', 196)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (198, N'Root-Admin-Config-notifications-smePortal-reminders', N'reminders', N'Root-Admin-Config-notifications-smePortal-Group', N'ENABLED', N'java.util.List', 197)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (199, N'Root-Admin-Config-notifications-onBoarding', N'onBoarding', N'Root-Admin-Config-notifications-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.notification.NotificationInfoDTO', 196)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (200, N'Root-Admin-Config-notifications-onBoarding-reminders', N'reminders', N'Root-Admin-Config-notifications-onBoarding-Group', N'ENABLED', N'java.util.List', 199)
INSERT [dbo].[lookup] ([id], [code], [field_name], [group_name], [lookup_status], [java_type], [ref_id]) VALUES (201, N'Root-Admin-Config-notifications-reportingAndClearance', N'reportingAndClearance', N'Root-Admin-Config-notifications-Group', N'ENABLED', N'com.zatca.lookups.api.v1.dto.notification.Reminder', 196)
SET IDENTITY_INSERT [dbo].[lookup] OFF
SET IDENTITY_INSERT [dbo].[lookup_meta_data] ON
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (173, N'passwordLength', N'java.lang.Long', 0, 174)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (174, N'minNumOfCharsLowercase', N'java.lang.Long', 0, 174)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (175, N'minNumOfCharsUppercase', N'java.lang.Long', 0, 174)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (176, N'minNumOfNums', N'java.lang.Long', 0, 174)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (177, N'minNumOfSymbols', N'java.lang.Long', 0, 174)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (178, N'value', N'java.lang.Long', 0, 175)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (179, N'timePeriod', N'java.lang.String', 0, 175)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (180, N'numOfIncorrectPasswordAttemp', N'java.lang.Long', 0, 176)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (181, N'value', N'java.lang.Long', 0, 176)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (182, N'timePeriod', N'java.lang.String', '', 176)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (183, N'lagBetweenEndAndGenerationInMonths', N'java.lang.Long', 0, 178)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (184, N'lagBetweenEndAndGenerationInDays', N'java.lang.Long', 0, 178)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (185, N'maxPeriodOfMatchingReports', N'java.lang.Long', 0, 178)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (186, N'maxHistoricalDataForMatchingReports', N'java.lang.Long', 0, 178)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (187, N'lagBetweenEndAndGenerationInMonths', N'java.lang.Long', 0, 179)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (188, N'lagBetweenEndAndGenerationInDays', N'java.lang.Long', 0, 179)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (189, N'maxPeriodOfMatchingReports', N'java.lang.Long', 0, 179)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (190, N'maxHistoricalDataForMatchingReports', N'java.lang.Long', 0, 179)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (191, N'numberOfInvoices', N'java.lang.Long', 0, 181)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (192, N'value', N'java.lang.Long', 0, 181)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (193, N'timePeriod', N'java.lang.String', N'', 181)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (194, N'value', N'java.lang.Long', 0, 182)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (195, N'timePeriod', N'java.lang.String', N'', 182)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (196, N'value', N'java.lang.Long', 0, 183)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (197, N'timePeriod', N'java.lang.String', N'', 183)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (198, N'maxNumberDocPerPage', N'java.lang.Long', 0, 184)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (199, N'value', N'java.lang.Long', 0, 185)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (200, N'timePeriod', N'java.lang.String', N'', 185)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (201, N'value', N'java.lang.Long', 0, 186)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (202, N'timePeriod', N'java.lang.String', N'', 186)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (203, N'value', N'java.lang.Long', 0, 188)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (204, N'timePeriod', N'java.lang.String', N'', 188)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (205, N'maxNumOfOtpMultiDevices', N'java.lang.Long', 0, 189)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (206, N'maxNumOfOtpDisplayed', N'java.lang.Long', 0, 189)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (207, N'maxNumberDocPerPage', N'java.lang.Long', 0, 190)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (208, N'otpLength', N'java.lang.Long', 0, 187)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (300, N'authorisedStatus', N'com.zatca.lookups.api.v1.dto.taxpayerAuthorisation.AuthorisedStatus', N'', 192)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (210, N'authorisedStatusUntilBufferPeriodEnd', N'com.zatca.lookups.api.v1.dto.taxpayerAuthorisation.AuthorisedStatusUntilBufferPeriodEnd', N'', 192)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (211, N'value', N'java.lang.Long', 0, 192)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (212, N'timePeriod', N'java.lang.String', N'', 192)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (213, N'authorisedStatus', N'com.zatca.lookups.api.v1.dto.taxpayerAuthorisation.AuthorisedStatus', N'', 193)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (214, N'authorisedStatusUntilBufferPeriodEnd', N'com.zatca.lookups.api.v1.dto.taxpayerAuthorisation.AuthorisedStatusUntilBufferPeriodEnd', N'', 193)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (215, N'value', N'java.lang.Long', 0, 193)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (216, N'timePeriod', N'java.lang.String', N'', 193)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (217, N'value', N'java.lang.Long', 0, 195)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (218, N'timePeriod', N'java.lang.String', N'', 195)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (219, N'time', N'java.lang.String', N'', 195)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (220, N'smePortalAccessRevocationNumberOfReminders', N'java.lang.Long', 0, 197)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (221, N'smePortalAccessRevocationNumberOfReminders', N'java.lang.Long', 0, 199)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (222, N'value', N'java.lang.Long', 0, 201)
INSERT [dbo].[lookup_meta_data] ([id], [name], [java_type], [value], [lookup_id]) VALUES (223, N'timePeriod', N'java.lang.String', N'', 201)
SET IDENTITY_INSERT [dbo].[lookup_meta_data] OFF




