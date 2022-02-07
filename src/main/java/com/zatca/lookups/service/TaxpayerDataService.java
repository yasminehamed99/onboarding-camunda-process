package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.taxpayerData.TaxpayerDataDTO;
import com.zatca.lookups.entity.configuration.taxpayerData.TaxpayerData;
import com.zatca.lookups.repository.TaxpayerDataRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaxpayerDataService {

    @Autowired
    private TaxpayerDataRepo taxpayerDataRepo;

    public void saveTaxpayerDataConfig(TaxpayerDataDTO request) {

        TaxpayerData taxpayerData = new TaxpayerData();
        taxpayerData.setTime(request.getTime());
        taxpayerData.setTimePeriod(request.getTimePeriod());
        taxpayerData.setValue(request.getValue());

        try {
            taxpayerDataRepo.save(taxpayerData);
            log.info("Taxpayer Data Entity: " + taxpayerData.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }
}
