package com.zatca.lookups.api.v1.dto;

import lombok.Data;

@Data
public class LockoutTimeConfigDto {

    private String timePeriod;

    private int value;

}
