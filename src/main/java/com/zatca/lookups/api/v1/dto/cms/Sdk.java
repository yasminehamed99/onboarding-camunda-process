package com.zatca.lookups.api.v1.dto.cms; 
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Sdk{
    @Valid
    public DownloadSDK downloadSDK;
    @Valid
    public EInvoiceSpecifications eInvoiceSpecifications;
    @Valid
    public SdkSupport sdkSupport;
    @NotNull(message = "versionHistory field is required")
    public List<VersionHistory> versionHistory;
}
