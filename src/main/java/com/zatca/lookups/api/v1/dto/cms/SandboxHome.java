package com.zatca.lookups.api.v1.dto.cms;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SandboxHome {

    @NotNull(message = "tabs field is required")
    public List<Tab> tabs;
    @NotNull(message = "news field is required")
    public List<News> news;
}
