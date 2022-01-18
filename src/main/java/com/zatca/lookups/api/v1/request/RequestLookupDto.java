package com.zatca.lookups.api.v1.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestLookupDto {

    private Long id;

    @NotBlank(message = "group can't be null or empty")
    private String group;

    @NotBlank(message = "titleAr can't be null or empty")
    private String titleAr;

    @NotBlank(message = "titleEn can't be null or empty")
    private String titleEn;

    @NotBlank(message = "code can't be null or empty")
    private String code;

    @NotBlank(message = "Parent lookup Code can't be null or zero")
    @Min(value = 1, message = "Parent lookup Code can't be null or zero")
    private String parentCode;

    private List<RequestLookupMetaDataDto> metaData;
}
