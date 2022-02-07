package com.zatca.lookups.entity.configuration.devportal;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DevPortal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
//    @Column(name = "password")
    @OneToOne()
    @JoinColumn(name = "password_id", referencedColumnName = "id")
    private Password password;
//    @Column(name = "Verification_Links_Validity_Period")
    @OneToOne()
    @JoinColumn(name = "verificationLinksValidityPeriod_id", referencedColumnName = "id")
    private VerificationLinksValidityPeriod verificationLinksValidityPeriod;
//    @Column(name = "Account_Lockout")
    @OneToOne()
    @JoinColumn(name = "accountLockout_id", referencedColumnName = "id")
    private AccountLockout accountLockout;

}
