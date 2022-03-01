package com.zatca.lookups.repository;

import com.zatca.lookups.entity.ErrorMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ErrorRepo extends JpaRepository<ErrorMessage, Long>, JpaSpecificationExecutor<ErrorMessage> {

    Optional<ErrorMessage> findByCode(String code);

    List<ErrorMessage> findByMessageContains(String keyword);

    List<ErrorMessage> findByCodeContainsAndArabicMessageContainsAndMessageContains(String errorCode, String message, String message1);

    List<ErrorMessage> findAllByCodeIn(List<String> errorCodes);

    List<ErrorMessage> findByCodeContains(String errorCode);
    List<ErrorMessage> findByCodeContainsAndArabicMessageContains(String errorCode, String message);

    List<ErrorMessage> findByCodeContainsAndMessageContains(String errorCode, String message);
}
