package com.zatca.lookups.api.v1.dto.cms;

import com.zatca.lookups.api.v1.dto.annotations.DataProperty;
import lombok.Data;

@Data
public class ReleaseNote {
    private String version;
    private String title;
    private String titleAr;
    @DataProperty
    private String description;
    @DataProperty
    private String descriptionAr;
}
