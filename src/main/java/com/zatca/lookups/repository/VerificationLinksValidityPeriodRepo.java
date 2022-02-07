package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.devportal.VerificationLinksValidityPeriod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationLinksValidityPeriodRepo extends JpaRepository<VerificationLinksValidityPeriod, Long> {
}
