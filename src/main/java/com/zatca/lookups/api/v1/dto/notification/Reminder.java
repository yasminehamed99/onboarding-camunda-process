package com.zatca.lookups.api.v1.dto.notification;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Reminder {

    @Min(value = 0, message = "value can't be less than zero")
    private long value;
    @NotBlank(message = "Time Period can't be null or empty")
    private String timePeriod;
}
