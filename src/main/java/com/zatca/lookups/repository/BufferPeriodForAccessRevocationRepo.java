package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.sme.BufferPeriodForAccessRevocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BufferPeriodForAccessRevocationRepo extends JpaRepository<BufferPeriodForAccessRevocation, Long> {
}
