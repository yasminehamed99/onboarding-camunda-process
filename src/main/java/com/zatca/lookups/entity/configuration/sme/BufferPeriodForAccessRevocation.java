package com.zatca.lookups.entity.configuration.sme;

import com.zatca.lookups.api.v1.dto.sme.BufferPeriodForAccessRevocationDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
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

    public void setProperties(BufferPeriodForAccessRevocationDTO dto) {
        value = dto.getValue();
        timePeriod = getTimePeriod();
    }
}
