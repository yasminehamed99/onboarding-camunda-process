package com.zatca.lookups.api.v1.dto.cms;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class Faqs {
    @NotBlank(message = "This field is required")
    public String arabicIntroduction;
    @NotBlank(message = "This field is required")
    public String englishIntroduction;
    public List<Question> questions;
    public List<Category> categories;
}
