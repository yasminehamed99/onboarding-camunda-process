package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.devportal.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepo extends JpaRepository<Password, Long> {
}
