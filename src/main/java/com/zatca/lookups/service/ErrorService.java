package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.errorMessages.ErrorDTO;
import com.zatca.lookups.entity.ErrorMessage;

import com.zatca.lookups.repository.ErrorRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ErrorService {

    @Autowired
    private ErrorRepo errorRepo;

    public List<ErrorDTO> findErrorByCodeAndMessage(String errorCode, String message) {


        Specification<ErrorMessage> specifications = new Specification<ErrorMessage>() {
            @Override
            public Predicate toPredicate(Root<ErrorMessage> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (errorCode != null && !errorCode.isBlank())
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("code"), "%" + errorCode + "%")));

                if (message != null && !message.isBlank()) {
                    if (isProbablyArabic(message)) {
                        predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("arabicMessage"), "%" + message + "%")));
                    } else {
                        predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("message"), "%" + message + "%")));
                    }
                }

                Predicate finalPredicate = null;
                if (predicates.isEmpty()) {
                    finalPredicate = criteriaBuilder.conjunction();
                } else {
                    for (Predicate p : predicates) {
                        if(finalPredicate == null)
                            finalPredicate = criteriaBuilder.and(p);
                        else
                            finalPredicate = criteriaBuilder.and(finalPredicate, p);
                    }
                }

                return finalPredicate;
            }

            private boolean isProbablyArabic(String s) {
                for (int i = 0; i < s.length();) {
                    int c = s.codePointAt(i);
                    if (c >= 0x0600 && c <= 0x06E0)
                        return true;
                    i += Character.charCount(c);
                }
                return false;
            }
        };

        return errorRepo.findAll(specifications).stream().map(e -> new ErrorDTO(e.getCode(), e.getMessage(), e.getArabicMessage(), e.getType())).collect(Collectors.toList());

//        if ((message == null || message.isEmpty()) && (errorCode!= null && !errorCode.isEmpty())) {
//            return errorRepo.findByCodeContains(errorCode).stream().map(e -> new ErrorDTO(e.getCode(), e.getMessage(), e.getArabicMessage(), e.getType())).collect(Collectors.toList());
//        } else if (isProbablyArabic(message) && (errorCode!= null && !errorCode.isEmpty())){
//            return errorRepo.findByCodeContainsAndArabicMessageContains(errorCode, message).stream().map(e -> new ErrorDTO(e.getCode(), e.getMessage(), e.getArabicMessage(), e.getType())).collect(Collectors.toList());
//        } else if (!isProbablyArabic(message) && (errorCode!= null && !errorCode.isEmpty())){
//            return errorRepo.findByCodeContainsAndMessageContains(errorCode, message).stream().map(e -> new ErrorDTO(e.getCode(), e.getMessage(), e.getArabicMessage(), e.getType())).collect(Collectors.toList());
//        } else {
//            return errorRepo.findAll().stream().map(e -> new ErrorDTO(e.getCode(), e.getMessage(), e.getArabicMessage(), e.getType())).collect(Collectors.toList());
//        }

//        List<ErrorMessage> errorMessages = errorRepo.findByCodeContainsAndArabicMessageContainsAndMessageContains(errorCode, message, message);

//        return errorMessages.stream().map(e -> new ErrorDTO(e.getCode(), e.getMessage(), e.getArabicMessage(), e.getType())).collect(Collectors.toList());

    }

    public void updateErrorMessage(List<ErrorDTO> errors) {

        Map<String, ErrorDTO> codeErrorMap = errors.stream().collect(Collectors.toMap(ErrorDTO::getCode, e -> e));

        List<ErrorMessage> oldErrors = errorRepo.findAllByCodeIn(errors.stream().map(ErrorDTO::getCode).collect(Collectors.toList()));

        oldErrors.stream().forEach(e -> {
            e.setMessage(codeErrorMap.get(e.getCode()).getMessage());
            e.setArabicMessage(codeErrorMap.get(e.getCode()).getArabicMessage());
            errorRepo.save(e);
        });

    }
}
