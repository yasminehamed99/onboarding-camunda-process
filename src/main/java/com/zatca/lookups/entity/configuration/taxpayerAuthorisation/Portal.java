package com.zatca.lookups.entity.configuration.taxpayerAuthorisation;

import com.zatca.lookups.api.v1.dto.taxpayerAuthorisation.AuthorisedStatus;
import com.zatca.lookups.api.v1.dto.taxpayerAuthorisation.AuthorisedStatusUntilBufferPeriodEnd;
import com.zatca.lookups.api.v1.dto.taxpayerAuthorisation.PortalDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Portal {

    public Portal(PortalDTO portalDTO) {
        authorisedStatus = portalDTO.getAuthorisedStatus();
        authorisedStatusUntilBufferPeriodEnd = portalDTO.getAuthorisedStatusUntilBufferPeriodEnd();
        value = portalDTO.getValue();
        timePeriod = portalDTO.getTimePeriod();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "Authorised_Status")
    @Enumerated
    private AuthorisedStatus authorisedStatus;
    @Column(name = "Authorised_Status_Until_Buffer_Period_End")
    @Enumerated
    private AuthorisedStatusUntilBufferPeriodEnd authorisedStatusUntilBufferPeriodEnd;
    @Column(name = "value")
    private long value;
    @Column(name = "Time_Period")
    private String timePeriod;
}
