package com.zatca.lookups.api.v1.dto.taxpayerData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportFreqZatcaDatawareHours {

    @Min(value = 0, message = "Value can't be less than zero")
    private long value;
    @NotBlank(message = "Time Period can't be null or empty")
    private String timePeriod;
    @NotBlank(message = "Time can't be null or empty")
    private String time;
}
