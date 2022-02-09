package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.taxpayerData.TaxpayerDataDTO;
import com.zatca.lookups.entity.configuration.taxpayerData.TaxpayerData;
import com.zatca.lookups.repository.TaxpayerDataRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
public class TaxpayerDataService {

    @Autowired
    private TaxpayerDataRepo taxpayerDataRepo;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void saveTaxpayerDataConfig(TaxpayerDataDTO request) {

        TaxpayerData taxpayerData = new TaxpayerData();
        taxpayerData.setTime(request.getImportFreqZatcaDatawareHours().getTime());
        taxpayerData.setTimePeriod(request.getImportFreqZatcaDatawareHours().getTimePeriod());
        taxpayerData.setValue(request.getImportFreqZatcaDatawareHours().getValue());

        try {
            taxpayerDataRepo.save(taxpayerData);
            log.info("Taxpayer Data Entity: " + taxpayerData.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void updateTaxpayerDataAuthConfig(TaxpayerDataDTO request) {

        taxpayerDataRepo.deleteAll();
        saveTaxpayerDataConfig(request);
    }

    public TaxpayerDataDTO findConfigs() {
        TaxpayerData configs = taxpayerDataRepo.findAll().get(0);
        TaxpayerDataDTO dto = new TaxpayerDataDTO();
        dto.getImportFreqZatcaDatawareHours().setTime(configs.getTime());
        dto.getImportFreqZatcaDatawareHours().setValue(configs.getValue());
        dto.getImportFreqZatcaDatawareHours().setTimePeriod(configs.getTimePeriod());

        return dto;
    }
}
