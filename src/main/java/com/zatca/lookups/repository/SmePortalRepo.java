package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.sme.SmePortal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmePortalRepo extends JpaRepository<SmePortal, Long> {
}
