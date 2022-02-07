package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.onboarding.NumOfOtp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumOfOtpRepo extends JpaRepository<NumOfOtp, Long> {
}