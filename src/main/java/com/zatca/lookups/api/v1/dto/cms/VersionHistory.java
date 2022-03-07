package com.zatca.lookups.api.v1.dto.cms;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class VersionHistory {
    @NotNull(message = "title field is required")
    public String title;
    @NotNull(message = "description field is required")
    public String description;
    @NotNull(message = "file field is required")
    public String file;
}
