package com.zatca.lookups.entity.configuration.taxpayerAuthorisation;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class TaxpayerAuthorisation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
//    @Column(name = "Einvoicing_Portal")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Einvoicing_Portal_id", referencedColumnName = "id")
    private Portal einvoicingPortal;
//    @Column(name = "Sme_Portal")
    @OneToOne(cascade = CascadeType.ALL)
    private Portal smePortal;
}
