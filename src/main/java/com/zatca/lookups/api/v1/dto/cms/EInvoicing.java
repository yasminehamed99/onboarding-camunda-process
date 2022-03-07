package com.zatca.lookups.api.v1.dto.cms;

import lombok.Data;

import javax.validation.Valid;

@Data
public class EInvoicing{
    @Valid
    public Home home;
}
