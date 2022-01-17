package com.zatca.lookups.repository;

import com.zatca.lookups.entity.Lookup;
import com.zatca.lookups.entity.LookupMetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaDataRepo extends JpaRepository<LookupMetaData, Long> {

    void deleteAllByLookupId(Long id);
}
