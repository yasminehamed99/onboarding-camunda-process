package com.zatca.lookups.repository;

import com.zatca.lookups.entity.Lookup;
import com.zatca.lookups.entity.LookupStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LookupRepo extends JpaRepository<Lookup, Long> {
    Optional<Lookup> findByCodeAndLookupStatus(String code, LookupStatus status);

    boolean existsByCode(String code);

    Optional<Lookup> findByCode(String root);

    List<Lookup> findByCodeContains(String code);
}
