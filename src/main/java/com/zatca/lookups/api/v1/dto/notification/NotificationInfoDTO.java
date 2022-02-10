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
    @NotNull(message = "Reminders can't be null")
    private List<Reminder> reminders;

    public List<Reminder> addReminders(List<com.zatca.lookups.entity.configuration.notification.Reminder> reminderList) {
        List<Reminder> temp = new ArrayList<>();
        for(com.zatca.lookups.entity.configuration.notification.Reminder reminder : reminderList) {
            Reminder tempReminder = new Reminder();
            tempReminder.setValue(reminder.getValue());
            tempReminder.setTimePeriod(reminder.getTimePeriod());
            temp.add(tempReminder);
        }
        return temp;
    }


}
