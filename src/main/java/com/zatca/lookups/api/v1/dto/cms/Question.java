package com.zatca.lookups.api.v1.dto.cms;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Question {
    @NotNull(message = "language field is required")
    public String language;
    @NotNull(message = "question field is required")
    public String question;
    @NotNull(message = "category field is required")
    public String category;
    @NotNull(message = "answer field is required")
    public String answer;
}
