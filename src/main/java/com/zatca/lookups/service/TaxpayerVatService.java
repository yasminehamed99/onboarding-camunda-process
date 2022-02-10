package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.TaxpayerVatDTO;
import com.zatca.lookups.entity.configuration.TaxpayerVat;
import com.zatca.lookups.exception.NotFoundBusinessException;
import com.zatca.lookups.repository.TaxpayerVatRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TaxpayerVatService {

    @Autowired
    private TaxpayerVatRepo taxpayerVatRepo;

    public void saveVAT(TaxpayerVatDTO request) {
        TaxpayerVat taxpayerVat = new TaxpayerVat();
        try {
            taxpayerVat.setVat(request.getVat());
            taxpayerVat.setClearanceStatus(request.getClearanceStatus());
            taxpayerVat = taxpayerVatRepo.save(taxpayerVat);
            log.info(taxpayerVat.toString() + "Saved successfully");
        } catch (Exception e) {
            log.error("TaxpayerVatService: " + e.getMessage());
        }

    }

    public List<TaxpayerVatDTO> findVatNumbers() {

        List<TaxpayerVat> vatNumbers = null;
        try {

            vatNumbers =  taxpayerVatRepo.findAll();
        } catch (Exception e) {
            throw new NotFoundBusinessException("No VAT Numbers found");
        }
        List<TaxpayerVatDTO> vatDTOS = new ArrayList<>();
        for (TaxpayerVat v: vatNumbers) {
            TaxpayerVatDTO dto = new TaxpayerVatDTO();
            dto.setVat(v.getVat());
            dto.setClearanceStatus(v.getClearanceStatus());
            vatDTOS.add(dto);
        }
        return vatDTOS;
    }
}
