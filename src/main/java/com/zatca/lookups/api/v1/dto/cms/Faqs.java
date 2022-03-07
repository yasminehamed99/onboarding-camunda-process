package com.zatca.lookups.api.v1.dto.cms;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Faqs {
    @NotNull(message = "arabicIntroduction field is required")
    public String arabicIntroduction;
    @NotNull(message = "englishIntroduction field is required")
    public String englishIntroduction;
    @NotNull(message = "questions field is required")
    public List<Question> questions;
    @NotNull(message = "categories field is required")
    public List<Category> categories;
}
