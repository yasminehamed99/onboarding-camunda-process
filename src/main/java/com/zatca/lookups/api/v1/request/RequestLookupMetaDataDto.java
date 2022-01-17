package com.zatca.lookups.api.v1.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestLookupMetaDataDto {

    @NotBlank(message = "MetaData name can't be null or empty")
    private String name;

    @NotBlank(message = "MetaData value can't be null or empty")
    private String value;
}