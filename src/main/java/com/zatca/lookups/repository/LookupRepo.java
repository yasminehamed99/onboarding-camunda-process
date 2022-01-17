package com.zatca.lookups.repository;

import com.zatca.lookups.entity.Lookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LookupRepo extends JpaRepository<Lookup, Long> {
    Optional<Lookup> findByCode(String code);

    boolean existsByCode(String code);
}
