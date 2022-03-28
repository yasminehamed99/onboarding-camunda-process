package com.zatca.lookups.api.v1.dto.cms;

import com.zatca.lookups.api.v1.dto.annotations.DataProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Paragraph {
    @NotNull(message = "status field is required")
    public String status;
    @NotNull(message = "englishText field is required")
    @DataProperty
    public String englishText;
    @NotNull(message = "arabicText field is required")
    @DataProperty
    public String arabicText;
}
