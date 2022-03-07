package com.zatca.lookups.api.v1.dto.cms;

import javax.validation.constraints.NotBlank;

public class ImageFile {

    @NotBlank(message = "This field is required")
    public String uid;
}
