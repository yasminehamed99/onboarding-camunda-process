package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.sme.InvoiceLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceLimitRepo extends JpaRepository<InvoiceLimit, Long> {
}
