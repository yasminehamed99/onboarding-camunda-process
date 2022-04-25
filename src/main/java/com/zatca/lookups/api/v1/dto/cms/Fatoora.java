package com.zatca.lookups.api.v1.dto.cms;

import lombok.Data;

@Data
public class Fatoora{
    public Paragraphs paragraphs;
    public FatooraHome home;
    public ListOfDevices listOfDevices;
    public InvoiceMatchingReports invoiceMatchingReports;
    public EinvoiceStatistics einvoiceStatistics;
}
