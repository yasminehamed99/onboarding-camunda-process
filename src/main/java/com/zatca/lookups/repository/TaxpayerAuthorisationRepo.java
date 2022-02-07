package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.taxpayerAuthorisation.TaxpayerAuthorisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxpayerAuthorisationRepo extends JpaRepository<TaxpayerAuthorisation, Long> {
}
