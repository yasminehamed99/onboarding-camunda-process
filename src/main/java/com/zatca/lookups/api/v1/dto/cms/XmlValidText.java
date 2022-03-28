package com.zatca.lookups.api.v1.dto.cms;

import com.zatca.lookups.api.v1.dto.annotations.DataProperty;
import lombok.Data;

@Data
public class XmlValidText {

    @DataProperty
    private String block1;
    @DataProperty
    private String block1Ar;
    @DataProperty
    private String block2;
    @DataProperty
    private String block2Ar;
}
