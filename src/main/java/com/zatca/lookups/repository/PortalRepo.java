package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.taxpayerAuthorisation.Portal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortalRepo extends JpaRepository<Portal, Long> {
}
