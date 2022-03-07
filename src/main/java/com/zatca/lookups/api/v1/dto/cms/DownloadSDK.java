package com.zatca.lookups.api.v1.dto.cms;

import javax.validation.constraints.NotBlank;

public class DownloadSDK {
    @NotBlank(message = "This field is required")
    public String block1;
    @NotBlank(message = "This field is required")
    public String block1Ar;
    @NotBlank(message = "This field is required")
    public String block2;
    @NotBlank(message = "This field is required")
    public String block2Ar;
    @NotBlank(message = "This field is required")
    public String userManual;
    @NotBlank(message = "This field is required")
    public String block3;
    @NotBlank(message = "This field is required")
    public String block3Ar;
    @NotBlank(message = "This field is required")
    public String sdkLink;
}
