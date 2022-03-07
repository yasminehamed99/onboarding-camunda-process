package com.zatca.lookups.api.v1.dto.cms;

import lombok.Data;

import javax.validation.Valid;

@Data
public class Sandbox{
    @Valid
    public Home home;
    @Valid
    public Faqs faqs;
    @Valid
    public Sdk sdk;
}
