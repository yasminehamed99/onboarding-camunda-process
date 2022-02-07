package com.zatca.lookups.entity.configuration.devportal;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AccountLockout {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "Num_Of_Incorrect_Password_Attempts")
    private long numOfIncorrectPasswordAttempts;
    @Column(name = "value")
    private long value;
    @Column(name = "Time_Period")
    private String timePeriod;
    @OneToOne(mappedBy = "accountLockout")
    private DevPortal devPortal;

}
