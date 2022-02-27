package com.zatca.lookups.api.v1.dto;

import lombok.Data;

@Data
public class LockoutConfigDto {

    private int numOfAttempts;
}
