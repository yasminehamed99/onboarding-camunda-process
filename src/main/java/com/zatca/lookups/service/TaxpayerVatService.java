package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.TaxpayerVatDTO;
import com.zatca.lookups.api.v1.response.ResponseLookupDto;
import com.zatca.lookups.api.v1.response.ResponseLookupMetaDataDto;
import com.zatca.lookups.entity.Lookup;
import com.zatca.lookups.exception.NotFoundBusinessException;
import com.zatca.lookups.repository.LookupRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TaxpayerVatService {

    @Autowired
    private LookupService lookupService;

    @Autowired
    private LookupRepo lookupRepo;


    public void saveVatLookup(Lookup root) {
        root.setCode("Root-clearanceStatus");
        lookupRepo.save(root);

    }

    public String getClearanceStatus(String code, String vat) {
        ResponseLookupDto lookup = lookupService.findFromCodeByDepth(0, code);
        String status = null;

        if (lookup.getMetaDataMap().containsKey(vat)) {
            status = lookup.getMetaDataMap().get(vat);
        }
        return status;
    }
}
