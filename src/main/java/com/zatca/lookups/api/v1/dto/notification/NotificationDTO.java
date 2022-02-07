package com.zatca.lookups.api.v1.dto.notification;

import lombok.Data;

@Data
public class NotificationDTO {

    private NotificationInfoDTO smeNotification;
    private NotificationInfoDTO onboardingNotification;
    private Reminder reportingClearancePeriodicNotification;
}
