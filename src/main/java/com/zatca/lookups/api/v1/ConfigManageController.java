package com.zatca.lookups.api.v1;

import com.zatca.lookups.api.v1.dto.AdminConfigDTO;
import com.zatca.lookups.api.v1.dto.TaxpayerVatDTO;
import com.zatca.lookups.api.v1.dto.errorMessages.ErrorDTO;
import com.zatca.lookups.convertorEngine.ConvertorFacade;
import com.zatca.lookups.entity.Lookup;
import com.zatca.lookups.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/lookups/v1")
@Validated
public class ConfigManageController {

    @Autowired
    private ErrorService errorService;

    @Autowired
    private LookupService lookupService;

    @GetMapping("/search/errorCodeKeyWord")
    public ResponseEntity<List<ErrorDTO>> searchByErrorCodeKeyWord(@RequestParam("errorCode") String errorCode, @RequestParam("keyword") String keyword) {

        List<ErrorDTO> errors = errorService.findErrorByCodeAndMessage(errorCode, keyword);

        return ResponseEntity.ok(errors);
    }

    @PutMapping("/search/errorCodeKeyWord")
    public ResponseEntity<String> updateErrorMessages(@RequestBody List<ErrorDTO> errors) {

        errorService.updateErrorMessage(errors);

        return ResponseEntity.ok("Updated Successfully");
    }

    @PutMapping("/search/errorCodeKeyWordSingle")
    public ResponseEntity<String> updateErrorMessage(@RequestBody ErrorDTO error) {

        List<ErrorDTO> errors = new ArrayList<>();
        errors.add(error);

        errorService.updateErrorMessage(errors);

        return ResponseEntity.ok("Updated Successfully");
    }

    @GetMapping("/search/getErrorMessageByCode")
    public ResponseEntity<ErrorDTO> getErrorMessageByCode(@RequestParam String errorCode) {
        return ResponseEntity.ok(errorService.finErrorByCode(errorCode));
    }
}