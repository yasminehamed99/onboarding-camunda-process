package com.zatca.lookups.entity.configuration.devportal;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class VerificationLinksValidityPeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "Value")
    private long value;
    @Column(name = "Time_Period")
    private String timePeriod;
    @OneToOne(mappedBy = "verificationLinksValidityPeriod")
    private DevPortal devPortal;
}
