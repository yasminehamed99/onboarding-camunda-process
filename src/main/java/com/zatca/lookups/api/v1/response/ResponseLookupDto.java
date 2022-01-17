package com.zatca.lookups.api.v1.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseLookupDto {

    private String group;
    private String titleAr;
    private String titleEn;
    private String code;
    private Long parentLookupId;

    private List<ResponseLookupDto> childs;

    private List<ResponseLookupMetaDataDto> metaData;
}
