package com.zatca.lookups.entity.configuration.taxpayerData;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TaxpayerData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "value")
    private long value;
    @Column(name = "Time_Period")
    private String timePeriod;
    @Column(name = "time")
    private String time;
}
