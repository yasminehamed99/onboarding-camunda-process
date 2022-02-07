package com.zatca.lookups.api.v1.dto.notification;

import lombok.Data;

@Data
public class Reminder {

    private long value;
    private String timePeriod;
}
