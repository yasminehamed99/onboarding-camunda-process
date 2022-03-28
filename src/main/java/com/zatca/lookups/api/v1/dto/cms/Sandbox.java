package com.zatca.lookups.api.v1.dto.cms;

import lombok.Data;

import javax.validation.Valid;

@Data
public class Sandbox{
    @Valid
    private SandboxHome home;
    @Valid
    private Faqs faqs;
    @Valid
    private Sdk sdk;
    @Valid
    private XmlValidation xmlValidation;
    @Valid
    private Isb isb;
}
