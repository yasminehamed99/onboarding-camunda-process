package com.zatca.lookups.api.v1.dto.devportal;

import lombok.Data;

@Data
public class PasswordDTO {

    private long length;
    private long minNumOfLowerCase;
    private long minNumOfUpperCase;
    private long minNumOfNumbers;
    private long minNumOfSymbols;
}
