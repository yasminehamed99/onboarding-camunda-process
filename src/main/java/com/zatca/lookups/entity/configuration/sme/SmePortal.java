package com.zatca.lookups.entity.configuration.sme;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SmePortal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
//    @Column(name = "Invoice_Limit")
    @OneToOne()
    @JoinColumn(name = "invoiceLimit_id", referencedColumnName = "id")
    private InvoiceLimit invoiceLimit;
//    @Column(name = "Whitelist_Import_Frequency")
    @OneToOne()
    @JoinColumn(name = "Whitelist_Import_Frequency_id", referencedColumnName = "id")
    private WhitelistImportFrequency whitelistImportFrequency;
//    @Column(name = "Buffer_Period_For_Access_Revocation")
    @OneToOne()
    @JoinColumn(name = "Buffer_Period_For_Access_Revocation_id", referencedColumnName = "id")
    private BufferPeriodForAccessRevocation bufferPeriodForAccessRevocation;
    @Column(name = "Max_Num_Of_Docs_Displayed_Per_Page")
    private long maxNumOfDocsDisplayedPerPage;
//    private ViewListDTO viewList;
//    @Column(name = "Buffer_Period_For_Access_Renewal")
    @OneToOne()
    @JoinColumn(name = "Buffer_Period_For_Access_Renewal_id", referencedColumnName = "id")
    private BufferPeriodForAccessRenewal bufferPeriodForAccessRenewal;
//    @Column(name = "Buffer_Period_Cryptographic_ID_Revocation")
    @OneToOne()
    @JoinColumn(name = "Buffer_Period_Cryptographic_ID_Revocation_id", referencedColumnName = "id")
    private BufferPeriodCryptographicIdRevocation bufferPeriodCryptographicIdRevocation;
}
