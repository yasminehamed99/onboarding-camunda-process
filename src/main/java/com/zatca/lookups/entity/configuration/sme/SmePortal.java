package com.zatca.lookups.entity.configuration.sme;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class SmePortal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
//    @Column(name = "Invoice_Limit")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoiceLimit_id", referencedColumnName = "id")
    private InvoiceLimit invoicesLimit;
//    @Column(name = "Whitelist_Import_Frequency")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Whitelist_Import_Frequency_id", referencedColumnName = "id")
    private WhitelistImportFrequency smeWhiteListImportFreq;
//    @Column(name = "Buffer_Period_For_Access_Revocation")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Buffer_Period_For_Access_Revocation_id", referencedColumnName = "id")
    private BufferPeriodForAccessRevocation bufferedPeriodForAccessRevocation;
    @Column(name = "Max_Num_Of_Docs_Displayed_Per_Page")
    private long maxNumOfDocsDisplayedPerPage;
//    private ViewListDTO viewList;
//    @Column(name = "Buffer_Period_For_Access_Renewal")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Buffer_Period_For_Access_Renewal_id", referencedColumnName = "id")
    private BufferPeriodForAccessRenewal bufferedPeriodForAccessRenew;
//    @Column(name = "Buffer_Period_Cryptographic_ID_Revocation")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Buffer_Period_Cryptographic_ID_Revocation_id", referencedColumnName = "id")
    private BufferPeriodCryptographicIdRevocation bufferedPeriodForCSIDRevocationOnceEGSIsOnboarding;
}
