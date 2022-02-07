package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.invoiceMatchingReports.InvoiceMatchingReports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceMatchingReportsRepo extends JpaRepository<InvoiceMatchingReports, Long> {
}
