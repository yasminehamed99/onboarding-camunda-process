package com.zatca.lookups.api.v1.dto.cms; 
public class News{
    @NotBlank(message = "This field is required") 
 public String title;
    @NotBlank(message = "This field is required") 
 public String language;
    @NotBlank(message = "This field is required") 
 public String image;
    public ImageFile imageFile;
}
