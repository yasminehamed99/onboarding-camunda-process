package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.onboarding.Onboarding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnboardingRepo extends JpaRepository<Onboarding, Long> {
}
