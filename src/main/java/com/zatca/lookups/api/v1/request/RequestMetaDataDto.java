package com.zatca.lookups.api.v1.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestMetaDataDto {

    List<RequestLookupMetaDataDto> metaData;
}
