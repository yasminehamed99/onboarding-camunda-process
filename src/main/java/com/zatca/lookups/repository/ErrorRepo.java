package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.errorMessages.Error;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ErrorRepo extends JpaRepository<Error, Long> {

    Optional<Error> findByErrorCode(String errorCode);
}
