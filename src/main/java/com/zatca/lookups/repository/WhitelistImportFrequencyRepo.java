package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.sme.WhitelistImportFrequency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhitelistImportFrequencyRepo extends JpaRepository<WhitelistImportFrequency, Long> {
}
