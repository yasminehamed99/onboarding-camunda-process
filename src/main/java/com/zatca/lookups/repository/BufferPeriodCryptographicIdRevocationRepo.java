package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.sme.BufferPeriodCryptographicIdRevocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BufferPeriodCryptographicIdRevocationRepo extends JpaRepository<BufferPeriodCryptographicIdRevocation, Long> {
}
