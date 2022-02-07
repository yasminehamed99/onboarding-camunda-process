package com.zatca.lookups.entity.configuration.sme;

import com.zatca.lookups.api.v1.dto.sme.BufferPeriodForAccessRevocationDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BufferPeriodForAccessRevocation {

    public BufferPeriodForAccessRevocation(BufferPeriodForAccessRevocationDTO dto) {

        value = dto.getValue();
        timePeriod = getTimePeriod();

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "value")
    private long value;
    @Column(name = "Time_Period")
    private String timePeriod;
}
