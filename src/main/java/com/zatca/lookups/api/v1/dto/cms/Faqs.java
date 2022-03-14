package com.zatca.lookups.api.v1.dto.cms;

import com.zatca.lookups.api.v1.dto.annotations.DataProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Faqs {
    @NotNull(message = "arabicIntroduction field is required")
    @DataProperty
    public String arabicIntroduction;
    @NotNull(message = "englishIntroduction field is required")
    @DataProperty
    public String englishIntroduction;
    @NotNull(message = "questions field is required")
    @DataProperty
    public List<Question> questions;
    @NotNull(message = "categories field is required")
    @DataProperty
    public List<Category> categories;
}
