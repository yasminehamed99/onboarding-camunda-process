package com.zatca.lookups.api.v1.dto.cms; 
public class Tab{
    @NotBlank(message = "This field is required") 
 public String file;
    @NotBlank(message = "This field is required") 
 public String arabicTitle;
    @NotBlank(message = "This field is required") 
 public String englishTitle;
    @NotBlank(message = "This field is required") 
 public String link;
}
