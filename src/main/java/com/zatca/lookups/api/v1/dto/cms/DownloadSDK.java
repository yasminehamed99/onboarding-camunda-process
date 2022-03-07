package com.zatca.lookups.api.v1.dto.cms;

import com.zatca.lookups.api.v1.dto.annotations.DataProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DownloadSDK {
    @NotNull(message = "block1 field is required")
    public String block1;
    @NotNull(message = "block1Ar field is required")
    public String block1Ar;
    @NotNull(message = "block2 field is required")
    public String block2;
    @NotNull(message = "block2Ar field is required")
    public String block2Ar;
    @NotNull(message = "userManual field is required")
    public String userManual;
    @NotNull(message = "block3 field is required")
    @DataProperty
    public String block3;
    @NotNull(message = "block3Ar field is required")
    @DataProperty
    public String block3Ar;
    @NotNull(message = "sdkLink field is required")
    public String sdkLink;
}
