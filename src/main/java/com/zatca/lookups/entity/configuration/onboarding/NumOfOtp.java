package com.zatca.lookups.entity.configuration.onboarding;

import com.zatca.lookups.api.v1.dto.onboarding.NumOfOtpDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class NumOfOtp {

    public NumOfOtp(NumOfOtpDTO dto) {
        maxNumOfOtpDisplayed = dto.getMaxNumOfOtpDisplayed();
        maxNumOfOtpMultiDevices = dto.getMaxNumOfOtpMultiDevices();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "Max_Num_Of_Otp_Multi_Devices")
    private long maxNumOfOtpMultiDevices;
    @Column(name = "Max_Num_Of_Otp_Displayed")
    private long maxNumOfOtpDisplayed;

    @OneToOne(mappedBy = "numOfOtp")
    private Onboarding onboarding;

}
