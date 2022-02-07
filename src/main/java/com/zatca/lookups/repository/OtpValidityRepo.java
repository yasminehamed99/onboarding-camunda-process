package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.onboarding.OtpValidity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpValidityRepo extends JpaRepository<OtpValidity, Long> {

}
