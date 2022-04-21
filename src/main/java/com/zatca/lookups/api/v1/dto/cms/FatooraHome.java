package com.zatca.lookups.api.v1.dto.cms;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class FatooraHome {

    @NotNull(message = "tabs field is required")

    public List<Tab> tabs;
    @NotBlank(message = "userManuals field is required")
    private String userManuals;
}
