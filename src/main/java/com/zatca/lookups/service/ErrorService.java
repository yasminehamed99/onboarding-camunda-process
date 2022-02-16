package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.errorMessages.ErrorDTO;
import com.zatca.lookups.entity.ErrorMessage;

import com.zatca.lookups.exception.NotFoundBusinessException;
import com.zatca.lookups.repository.ErrorRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ErrorService {

    @Autowired
    private ErrorRepo errorRepo;

    public ErrorDTO findErrorByCode(String errorCode) {

        ErrorMessage errorMessage = errorRepo.findByCode(errorCode).orElseThrow(() -> new NotFoundBusinessException("Can't find error with code " + errorCode));
        ErrorDTO dto = new ErrorDTO();
        dto.setCode(errorMessage.getCode());
        dto.setMessage(errorMessage.getMessage());
        dto.setType(errorMessage.getType());

        return dto;

    }
}
