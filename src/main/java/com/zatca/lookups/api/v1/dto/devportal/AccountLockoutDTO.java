package com.zatca.lookups.api.v1.dto.devportal;

import lombok.Data;

@Data
public class AccountLockoutDTO {

    private long numOfIncorrectPasswordAttempts;
    private long value;
    private String timePeriod;
}
