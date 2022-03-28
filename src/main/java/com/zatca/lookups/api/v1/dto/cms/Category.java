package com.zatca.lookups.api.v1.dto.cms;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zatca.lookups.api.v1.dto.annotations.DataProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Category {

    @NotNull(message = "arabicTitle field is required")
    public String arabicTitle;
    @NotNull(message = "englishTitle field is required")
    public String englishTitle;
    @NotNull(message = "icon field is required")
    @DataProperty
    public String icon;
    @NotNull(message = "uniqueId field is required")
    public String uniqueId;
    @NotNull(message = "iconFile field is required")
    @JsonProperty("iconFile")
    public String iconFile;
}
