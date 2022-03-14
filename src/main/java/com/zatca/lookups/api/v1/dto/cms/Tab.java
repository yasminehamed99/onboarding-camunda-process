package com.zatca.lookups.api.v1.dto.cms;

import com.zatca.lookups.api.v1.dto.annotations.DataProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Tab {
    @NotNull(message = "file field is required")
    @DataProperty
    public String file;
    @NotNull(message = "arabicTitle field is required")
    public String arabicTitle;
    @NotNull(message = "englishTitle field is required")
    public String englishTitle;
    @NotNull(message = "link field is required")
    public String link;
}
