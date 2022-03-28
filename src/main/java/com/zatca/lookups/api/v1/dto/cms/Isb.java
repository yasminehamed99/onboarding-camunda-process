package com.zatca.lookups.api.v1.dto.cms;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Isb {
    private ArrayList<ReleaseNote> releaseNotes;
    private Overview overview;
}
