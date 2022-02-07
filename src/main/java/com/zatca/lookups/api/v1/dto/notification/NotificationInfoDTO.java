package com.zatca.lookups.api.v1.dto.notification;

import lombok.Data;

import java.util.List;

@Data
public class NotificationInfoDTO {

    private long numOfReminders;
    private List<Reminder> reminders;
}
