package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.sme.BufferPeriodForAccessRenewal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BufferPeriodForAccessRenewalRepo extends JpaRepository<BufferPeriodForAccessRenewal, Long> {
}
