package com.zatca.lookups.entity.configuration;

import com.zatca.lookups.api.v1.dto.VatStatus;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TaxpayerVat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "VAT")
    private String vat;
    @Column(name = "VAT_Status", columnDefinition = "VARCHAR(50)")
    @Enumerated(EnumType.STRING)
    private VatStatus clearanceStatus;
}
