package com.zatca.lookups.api.v1.dto.cms;

import lombok.Data;

import java.util.List;

@Data
public class Isb {
    private List<ReleaseNote> releaseNotes;
    private Overview overview;
}
