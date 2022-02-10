package com.zatca.lookups.repository;

import com.zatca.lookups.entity.ClearanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClearanceStatusRepo extends JpaRepository<ClearanceStatus, Long> {
}
