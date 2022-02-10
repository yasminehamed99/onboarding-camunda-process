package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.errorMessages.ErrorDTO;
import com.zatca.lookups.entity.configuration.errorMessages.Error;
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

        Error error = errorRepo.findByErrorCode(errorCode).orElseThrow(() -> new NotFoundBusinessException("Can't find error with code " + errorCode));
        ErrorDTO dto = new ErrorDTO();
        dto.setErrorCode(error.getErrorCode());
        dto.setErrorMessage(error.getErrorMessage());

        return dto;

    }
}
