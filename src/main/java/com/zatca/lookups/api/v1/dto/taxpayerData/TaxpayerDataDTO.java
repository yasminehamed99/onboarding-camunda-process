package com.zatca.lookups.api.v1.dto.taxpayerData;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class TaxpayerDataDTO {

    public TaxpayerDataDTO() {
        importFreqZatcaDatawareHours = new ImportFreqZatcaDatawareHours();
    }

    @Valid
    private ImportFreqZatcaDatawareHours importFreqZatcaDatawareHours;
}
