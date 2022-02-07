package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.taxpayerData.TaxpayerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxpayerDataRepo extends JpaRepository<TaxpayerData, Long> {
}
