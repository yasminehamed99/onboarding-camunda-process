package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.invoiceMatchingReports.TwoWayClearance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwoWayClearanceRepo extends JpaRepository<TwoWayClearance, Long> {
}
