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
        numOfInvoices = dto.getNumOfInvoices();
        timePeriod = dto.getTimePeriod();
        value = dto.getValue();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "Num_Of_Invoices")
    private long numOfInvoices;
    @Column(name = "value")
    private long value;
    @Column(name = "Time_Period")
    private String timePeriod;


}
