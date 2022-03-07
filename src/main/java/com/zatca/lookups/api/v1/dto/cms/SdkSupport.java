package com.zatca.lookups.api.v1.dto.cms; 
public class SdkSupport{
    @NotBlank(message = "This field is required") 
 public String arabicSdkSupport;
    @NotBlank(message = "This field is required") 
 public String englishSdkSupport;
}
