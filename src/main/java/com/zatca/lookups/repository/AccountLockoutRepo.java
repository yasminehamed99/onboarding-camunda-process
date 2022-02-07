package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.devportal.AccountLockout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountLockoutRepo extends JpaRepository<AccountLockout, Long> {
}
