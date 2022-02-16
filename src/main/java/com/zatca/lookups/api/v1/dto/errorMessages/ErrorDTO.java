package com.zatca.lookups.api.v1.dto.errorMessages;

import lombok.Data;

@Data
public class ErrorDTO {
    private String code;
    private String message;
    private String type;
}