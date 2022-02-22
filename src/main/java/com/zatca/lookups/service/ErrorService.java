package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.errorMessages.ErrorDTO;
import com.zatca.lookups.entity.ErrorMessage;

import com.zatca.lookups.exception.NotFoundBusinessException;
import com.zatca.lookups.repository.ErrorRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<ErrorDTO> findErrorByKeyword(String keyword) {
        List<ErrorMessage> errors = errorRepo.findByMessageContains(keyword);

        if (errors == null || errors.isEmpty()) {
            throw new NotFoundBusinessException("No Error Message Found for keyword: " + keyword);
        }

        List<ErrorDTO> errorDTOS = new ArrayList<>();
        for (ErrorMessage error : errors) {
            ErrorDTO temp = new ErrorDTO();
            temp.setType(error.getType());
            temp.setCode(error.getCode());
            temp.setMessage(error.getMessage());
            errorDTOS.add(temp);
        }

        return errorDTOS;

    }
}
