package com.zatca.lookups.entity.configuration.sme;

import com.zatca.lookups.api.v1.dto.sme.BufferPeriodForAccessRenewalDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BufferPeriodForAccessRenewal {

    public BufferPeriodForAccessRenewal(BufferPeriodForAccessRenewalDTO dto) {
        value = dto.getValue();
        timePeriod = dto.getTimePeriod();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "value")
    private long value;
    @Column(name = "Time_Period")
    private String timePeriod;
}
