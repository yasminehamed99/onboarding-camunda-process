package com.zatca.lookups.api.v1.dto.cms;

import com.zatca.lookups.api.v1.dto.annotations.DataProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SdkSupport {
    @NotNull(message = "arabicSdkSupport field is required")
    @DataProperty
    public String arabicSdkSupport;
    @NotNull(message = "englishSdkSupport field is required")
    @DataProperty
    public String englishSdkSupport;
}
