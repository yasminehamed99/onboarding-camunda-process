package com.zatca.lookups.entity.configuration.onboarding;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Onboarding {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @OneToOne()
    @JoinColumn(name = "otpValidity_id", referencedColumnName = "id")
    private OtpValidity otpValidity;
    @Column(name = "otp_Length")
    private long otpLength;
    @OneToOne()
    @JoinColumn(name = "numOfOtp_id", referencedColumnName = "id")
    private NumOfOtp numOfOtp;
    @Column(name = "Max_Num_Of_Docs_Displayed_Per_Page")
    private long maxNumOfDocsDisplayedPerPage;
//    private ViewListDTO viewList;
}
