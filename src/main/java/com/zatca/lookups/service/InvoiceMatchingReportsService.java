package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.invoiceMatchingReports.InvoiceMatchingReportsDTO;
import com.zatca.lookups.entity.configuration.invoiceMatchingReports.InvoiceMatchingReports;
import com.zatca.lookups.entity.configuration.invoiceMatchingReports.TwoWayClearance;
import com.zatca.lookups.repository.InvoiceMatchingReportsRepo;
import com.zatca.lookups.repository.TwoWayClearanceRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InvoiceMatchingReportsService {

    @Autowired
    private TwoWayClearanceRepo twoWayClearanceRepo;

    @Autowired
    private InvoiceMatchingReportsRepo invoiceMatchingReportsRepo;

    public void saveInvoiceMatchingReportsConfig(InvoiceMatchingReportsDTO dto) {
        TwoWayClearance twoWayClearance = new TwoWayClearance(dto.getTwoWayClearance());
        TwoWayClearance selfBilled = new TwoWayClearance(dto.getSelfBilled());
        InvoiceMatchingReports invoiceMatchingReports = new InvoiceMatchingReports();
        invoiceMatchingReports.setSelfBilled(selfBilled);
        invoiceMatchingReports.setTwoWayClearance(twoWayClearance);

        try {
            twoWayClearanceRepo.save(twoWayClearance);
            twoWayClearanceRepo.save(selfBilled);
            invoiceMatchingReportsRepo.save(invoiceMatchingReports);
            log.info("Invoice Matching Reports: " + invoiceMatchingReports.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }
}
