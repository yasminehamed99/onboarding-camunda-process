package com.zatca.lookups.api.v1.dto.cms;

import javax.validation.constraints.NotBlank;

public class Category {

    @NotBlank(message = "This field is required")
    public String arabicTitle;
    @NotBlank(message = "This field is required")
    public String englishTitle;
    @NotBlank(message = "This field is required")
    public String icon;
    @NotBlank(message = "This field is required")
    public String uniqueId;
    @NotBlank(message = "This field is required")
    public String iconFile;
}
