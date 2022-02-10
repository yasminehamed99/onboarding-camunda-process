package com.zatca.lookups.entity.configuration.onboarding;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Onboarding {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "otpValidity_id", referencedColumnName = "id")
    private OtpValidity otpValidity;
    @Column(name = "otp_Length")
    private long otpLength;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "numOfOtp_id", referencedColumnName = "id")
    private NumOfOtp numOfOtp;
    @Column(name = "Max_Num_Of_Docs_Displayed_Per_Page")
    private long maxNumOfDocsDisplayedPerPage;
//    private ViewListDTO viewList;
}
