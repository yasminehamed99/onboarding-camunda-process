package com.zatca.lookups.repository;

import com.zatca.lookups.entity.Lookup;
import com.zatca.lookups.entity.LookupStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LookupRepo extends JpaRepository<Lookup, Long> {
    Optional<Lookup> findByCodeAndLookupStatus(String code, LookupStatus status);

    boolean existsByCode(String code);

    Optional<Lookup> findByCode(String root);

    List<Lookup> findByCodeContains(String code);

//    Lookup findByCodeAndLookupMetaDataNameAndLookupMetaDataValue(String lookupCode, String name, String value);
    @Query(value = "  select * from lookup l left " +
            "outer join lookup_meta_data lm on l.id=lm.lookup_id " +
            "where lm.name=:name and lm.value=:value " +
            "and l.code like %:lookupCode% ",nativeQuery = true)
    List<Lookup> findByLookupMetaDataNameAndLookupMetaDataValueAndCodeLike( String name, String value,String lookupCode);
}
