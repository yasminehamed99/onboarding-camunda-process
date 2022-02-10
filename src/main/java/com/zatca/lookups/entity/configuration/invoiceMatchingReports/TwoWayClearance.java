package com.zatca.lookups.entity.configuration.invoiceMatchingReports;

import com.zatca.lookups.api.v1.dto.invoiceMatchingReports.TwoWayClearanceDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class TwoWayClearance {

    public TwoWayClearance(TwoWayClearanceDTO dto) {
        lagBetweenEndAndGenerationInMonths = dto.getLagBetweenEndAndGenerationInMonths();
        lagBetweenEndAndGenerationInDays = dto.getLagBetweenEndAndGenerationInDays();
        maxPeriodOfMatchingReports = dto.getMaxPeriodOfMatchingReports();
        maxHistoricalDataForMatchingReports = dto.getMaxHistoricalDataForMatchingReports();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "Lag_Between_End_And_Generation_In_Months")
    private long lagBetweenEndAndGenerationInMonths;
    @Column(name = "Lag_Between_End_And_Generation_In_Days")
    private long lagBetweenEndAndGenerationInDays;
    @Column(name = "Max_Period_Of_Matching_Reports")
    private long maxPeriodOfMatchingReports;
    @Column(name = "Max_Historical_Data_For_Matching_Reports")
    private long maxHistoricalDataForMatchingReports;

    @OneToOne(mappedBy = "twoWayClearance")
    private InvoiceMatchingReports invoiceMatchingReports;
    @OneToOne(mappedBy = "selfBilled")
    private InvoiceMatchingReports invoiceMatchingReports1;

    public void setTwoWayClearanceProperties(TwoWayClearanceDTO dto) {
        lagBetweenEndAndGenerationInMonths = dto.getLagBetweenEndAndGenerationInMonths();
        lagBetweenEndAndGenerationInDays = dto.getLagBetweenEndAndGenerationInDays();
        maxPeriodOfMatchingReports = dto.getMaxPeriodOfMatchingReports();
        maxHistoricalDataForMatchingReports = dto.getMaxHistoricalDataForMatchingReports();
    }

}
