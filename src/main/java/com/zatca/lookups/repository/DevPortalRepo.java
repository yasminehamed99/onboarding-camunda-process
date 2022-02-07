package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.devportal.DevPortal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevPortalRepo extends JpaRepository<DevPortal, Long> {
}
