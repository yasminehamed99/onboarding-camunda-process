package com.zatca.lookups.api.v1.dto.notification;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class NotificationDTO {

    public NotificationDTO() {
        smePortal = new NotificationInfoDTO();
        onBoarding = new NotificationInfoDTO();
        reportingAndClearance = new Reminder();
    }

    @NotNull(message = "smeNotification config Can't be null")
    private NotificationInfoDTO smePortal;
    @NotNull(message = "onboardingNotification config Can't be null")
    private NotificationInfoDTO onBoarding;
    @NotNull(message = "reportingClearancePeriodicNotification config Can't be null")
    private Reminder reportingAndClearance;


}
