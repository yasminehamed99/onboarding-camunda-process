package com.zatca.lookups.api.v1.dto.cms;

import com.zatca.lookups.api.v1.dto.annotations.DataProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class News {
    @NotNull(message = "title field is required")
    public String title;
    @NotNull(message = "language field is required")
    public String language;
    @NotNull(message = "image field is required")
    @DataProperty
    public String image;
    @Valid
    public ImageFile imageFile;
}
