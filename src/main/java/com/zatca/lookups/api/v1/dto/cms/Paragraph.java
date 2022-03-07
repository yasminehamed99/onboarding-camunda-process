package com.zatca.lookups.api.v1.dto.cms; 
public class Paragraph{
    @NotBlank(message = "This field is required") 
 public String status;
    @NotBlank(message = "This field is required") 
 public String englishText;
    @NotBlank(message = "This field is required") 
 public String arabicText;
}
