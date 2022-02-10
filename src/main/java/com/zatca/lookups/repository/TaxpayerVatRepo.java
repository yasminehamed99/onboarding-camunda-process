package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.TaxpayerVat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxpayerVatRepo extends JpaRepository<TaxpayerVat, Long> {
}
