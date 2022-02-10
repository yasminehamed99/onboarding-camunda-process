package com.zatca.lookups.entity.configuration.sme;

import com.zatca.lookups.api.v1.dto.sme.WhitelistImportFrequencyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class WhitelistImportFrequency {

    public WhitelistImportFrequency(WhitelistImportFrequencyDTO dto) {
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

    public void setProperties(WhitelistImportFrequencyDTO dto) {
        value = dto.getValue();
        timePeriod = dto.getTimePeriod();
    }
}
