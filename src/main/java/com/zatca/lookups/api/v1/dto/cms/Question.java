package com.zatca.lookups.api.v1.dto.cms; 
public class Question{
    @NotBlank(message = "This field is required") 
 public String language;
    @NotBlank(message = "This field is required") 
 public String question;
    @NotBlank(message = "This field is required") 
 public String category;
    @NotBlank(message = "This field is required") 
 public String answer;
}
