package com.zatca.lookups.service;

import com.zatca.lookups.exception.NotFoundBusinessException;
import com.zatca.lookups.repository.ClearanceStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClearanceStatusService {

    @Autowired
    private ClearanceStatusRepo clearanceStatusRepo;

    public String findClearanceStatus() {

        try {
            return clearanceStatusRepo.findAll().get(0).getStatus();
        } catch (Exception e) {
            throw new NotFoundBusinessException("Clearance Status not found");
        }


    }
}
