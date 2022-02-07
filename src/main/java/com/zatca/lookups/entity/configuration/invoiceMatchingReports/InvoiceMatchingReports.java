package com.zatca.lookups.entity.configuration.invoiceMatchingReports;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class InvoiceMatchingReports {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @OneToOne()
    @JoinColumn(name = "twoWayClearance_id", referencedColumnName = "id")
    private TwoWayClearance twoWayClearance;
    @OneToOne()
//    @JoinColumn(name = "twoWayClearance_id", referencedColumnName = "id")
    private TwoWayClearance selfBilled;

}
