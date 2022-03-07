package com.zatca.lookups.api.v1.dto.cms; 
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
@Data
public class Home {

    @NotNull(message = "tabs field is required")
    public List<Tab> tabs;
    @NotNull(message = "news field is required")
    public List<News> news;
    @NotNull(message = "paragraph field is required")
    public List<Paragraph> paragraph;
}
