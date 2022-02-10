package com.zatca.lookups.api.v1.dto.devportal;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class PasswordDTO {

    @Min(value = 6, message = "Password length can't be less than 6")
    private long passwordLength;
    @Min(value = 1, message = "NumOfCharsLowercase  can't be less than 1")
    private long minNumOfCharsLowercase;
    @Min(value = 1, message = "minNumOfCharsUppercase  can't be less than 1")
    private long minNumOfCharsUppercase;
    @Min(value = 1, message = "minNumOfNums  can't be less than 1")
    private long minNumOfNums;
    @Min(value = 1, message = "minNumOfSymbols  can't be less than 1")
    private long minNumOfSymbols;
}
