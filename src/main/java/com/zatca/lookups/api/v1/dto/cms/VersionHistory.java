package com.zatca.lookups.api.v1.dto.cms; 
public class VersionHistory{
    @NotBlank(message = "This field is required") 
 public String title;
    @NotBlank(message = "This field is required") 
 public String description;
    @NotBlank(message = "This field is required") 
 public String file;
}
