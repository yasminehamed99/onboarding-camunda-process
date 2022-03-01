package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.errorMessages.ErrorDTO;
import com.zatca.lookups.entity.ErrorMessage;

import com.zatca.lookups.repository.ErrorRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        List<ErrorMessage> errorMessages = errorRepo.findByCodeContainsAndArabicMessageContainsAndMessageContains(errorCode, message, message);

        return errorMessages.stream().map(e -> new ErrorDTO(e.getCode(), e.getMessage(), e.getArabicMessage(), e.getType())).collect(Collectors.toList());

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
