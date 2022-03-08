package com.zatca.lookups.api.v1.dto.notification;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class NotificationInfoDTO {

    @Min(value = 0, message = "SME Portal Access Revocation Number Of Reminders can't be less than zero")
    private long smePortalAccessRevocationNumberOfReminders;
    private List<Reminder> reminders;

}
