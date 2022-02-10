package com.zatca.lookups.api.v1.dto.sme;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class ViewListDTO {

    @Min(value = 1, message = "Max Num Of Docs Per Page can't be less than one")
    private long maxNumberDocPerPage;
}
