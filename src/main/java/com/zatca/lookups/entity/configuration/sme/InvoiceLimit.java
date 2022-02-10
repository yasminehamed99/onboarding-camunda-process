package com.zatca.lookups.entity.configuration.sme;

import com.zatca.lookups.api.v1.dto.sme.InvoiceLimitDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class InvoiceLimit {

    public InvoiceLimit(InvoiceLimitDTO dto) {
        numberOfInvoices = dto.getNumberOfInvoices();
        timePeriod = dto.getTimePeriod();
        value = dto.getValue();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "Num_Of_Invoices")
    private long numberOfInvoices;
    @Column(name = "value")
    private long value;
    @Column(name = "Time_Period")
    private String timePeriod;

    public void setProperties(InvoiceLimitDTO dto) {
        numberOfInvoices = dto.getNumberOfInvoices();
        timePeriod = dto.getTimePeriod();
        value = dto.getValue();
    }
}
