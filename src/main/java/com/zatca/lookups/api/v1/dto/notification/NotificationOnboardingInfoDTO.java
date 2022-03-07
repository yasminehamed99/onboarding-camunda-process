package com.zatca.lookups.api.v1.dto.notification;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class NotificationOnboardingInfoDTO {


    @Min(value = 0, message = "CSID Expiry Number Of Reminders can't be less than zero")
    private long csidExpiryNumberOfReminders;
    @NotNull(message = "Reminders can't be null")
    private List<Reminder> reminders;
}
