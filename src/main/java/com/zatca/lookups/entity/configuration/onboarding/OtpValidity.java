package com.zatca.lookups.entity.configuration.onboarding;

import com.zatca.lookups.api.v1.dto.onboarding.OtpValidityDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OtpValidity {

    public OtpValidity(OtpValidityDTO dto) {
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

    @OneToOne(mappedBy = "otpValidity")
    private Onboarding onboarding;
}
