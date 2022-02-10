
INSERT [dbo].[notification_info] ([id], [num_of_reminders]) VALUES (1, 3)
INSERT [dbo].[notification_info] ([id], [num_of_reminders]) VALUES (2, 0)

INSERT [dbo].[reminder] ([id], [time_period], [value], [notification_id]) VALUES (589, N'55', 15, 2)
INSERT [dbo].[reminder] ([id], [time_period], [value], [notification_id]) VALUES (590, N'66', 16, 2)
INSERT [dbo].[reminder] ([id], [time_period], [value], [notification_id]) VALUES (591, N'77', 17, 2)
INSERT [dbo].[reminder] ([id], [time_period], [value], [notification_id]) VALUES (592, N'1', 19, NULL)
INSERT [dbo].[reminder] ([id], [time_period], [value], [notification_id]) VALUES (593, N'22', 12, 1)
INSERT [dbo].[reminder] ([id], [time_period], [value], [notification_id]) VALUES (594, N'33', 13, 1)
INSERT [dbo].[reminder] ([id], [time_period], [value], [notification_id]) VALUES (595, N'44', 14, 1)

INSERT [dbo].[notification] ([id], [onboarding_notification_id], [reminder_id], [sme_notification_id]) VALUES (588, 2, 592, 1)

INSERT [dbo].[num_of_otp] ([id], [max_num_of_otp_displayed], [max_num_of_otp_multi_devices]) VALUES (580, 0, 0)

INSERT [dbo].[otp_validity] ([id], [time_period], [value]) VALUES (581, N'1', 20)

INSERT [dbo].[onboarding] ([id], [max_num_of_docs_displayed_per_page], [otp_length], [num_of_otp_id], [otp_validity_id]) VALUES (579, 10, 9, 580, 581)

INSERT [dbo].[password] ([id], [length], [min_num_of_lower_case], [min_num_of_numbers], [min_num_of_symbols], [min_num_of_upper_case]) VALUES (568, 6, 1, 2, 2, 1)

INSERT [dbo].[verification_links_validity_period] ([id], [time_period], [value]) VALUES (569, N'1', 34)

INSERT [dbo].[account_lockout] ([id], [num_of_incorrect_password_attempts], [time_period], [value]) VALUES (567, 23, N'2', 1)

INSERT [dbo].[dev_portal] ([id], [account_lockout_id], [password_id], [verification_links_validity_period_id]) VALUES (566, 567, 568, 569)

INSERT [dbo].[portal] ([id], [authorised_status], [authorised_status_until_buffer_period_end], [time_period], [value]) VALUES (583, 0, 1, N'Days', 5)
INSERT [dbo].[portal] ([id], [authorised_status], [authorised_status_until_buffer_period_end], [time_period], [value]) VALUES (584, 0, 1, N'Days', 5)

INSERT [dbo].[taxpayer_authorisation] ([id], [einvoicing_portal_id], [sme_portal_id]) VALUES (582, 583, 584)

INSERT [dbo].[two_way_clearance] ([id], [lag_between_end_and_generation_in_days], [lag_between_end_and_generation_in_months], [max_historical_data_for_matching_reports], [max_period_of_matching_reports]) VALUES (571, 200, 200, 200, 200)
INSERT [dbo].[two_way_clearance] ([id], [lag_between_end_and_generation_in_days], [lag_between_end_and_generation_in_months], [max_historical_data_for_matching_reports], [max_period_of_matching_reports]) VALUES (572, 100, 100, 100, 100)

INSERT [dbo].[invoice_matching_reports] ([id], [self_billed_id], [two_way_clearance_id]) VALUES (570, 571, 572)

INSERT [dbo].[whitelist_import_frequency] ([id], [time_period], [value]) VALUES (578, N'12', 12)

INSERT [dbo].[buffer_period_cryptographic_id_revocation] ([id], [time_period], [value]) VALUES (576, N'2', 20)

INSERT [dbo].[buffer_period_for_access_renewal] ([id], [time_period], [value]) VALUES (574, N'2', 20)

INSERT [dbo].[buffer_period_for_access_revocation] ([id], [time_period], [value]) VALUES (575, 'Day', 10)

INSERT [dbo].[invoice_limit] ([id], [num_of_invoices], [time_period], [value]) VALUES (577, 10, N'1', 3)

INSERT [dbo].[sme_portal] ([id], [max_num_of_docs_displayed_per_page], [buffer_period_cryptographic_id_revocation_id], [buffer_period_for_access_renewal_id], [buffer_period_for_access_revocation_id], [invoice_limit_id], [whitelist_import_frequency_id]) VALUES (573, 2, 576, 574, 575, 577, 578)

INSERT [dbo].[taxpayer_data] ([id], [time], [time_period], [value]) VALUES (585, N'20', N'1', 3)

INSERT [dbo].[taxpayer_vat] ([id], [vat_status], [vat]) VALUES (12, N'ENABLED', N'312345678900003')

INSERT INTO [dbo].[error] ([id],[error_code],[error_message]) VALUES (1,'BR-52','Each Additional supporting document (BG-24) shall contain a Supporting document reference (BT-122)')

INSERT INTO [dbo].[error]([id],[error_code],[error_message]) VALUES (2,'BR-31','Each Document level allowance (BG-20) shall have a Document level allowance amount (BT-92)')
