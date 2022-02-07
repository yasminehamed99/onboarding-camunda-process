package com.zatca.lookups.entity.configuration.taxpayerAuthorisation;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TaxpayerAuthorisation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
//    @Column(name = "Einvoicing_Portal")
    @OneToOne()
    @JoinColumn(name = "Einvoicing_Portal_id", referencedColumnName = "id")
    private Portal einvoicingPortal;
//    @Column(name = "Sme_Portal")
    @OneToOne
    private Portal smePortal;
}
