package com.zatca.lookups.api.v1;

import com.zatca.lookups.api.v1.dto.AdminConfigDTO;
import com.zatca.lookups.api.v1.dto.TaxpayerVatDTO;
import com.zatca.lookups.api.v1.dto.errorMessages.ErrorDTO;
import com.zatca.lookups.convertorEngine.ConvertorFacade;
import com.zatca.lookups.entity.Lookup;
import com.zatca.lookups.entity.LookupMetaData;
import com.zatca.lookups.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/lookups/v1")
@Validated
public class ConfigManageController {

    @Autowired
    private ErrorService errorService;

    @Autowired
    private TaxpayerVatService taxpayerVatService;

    @Autowired
    private ConvertorFacade convertor;

    @Autowired
    private LookupService lookupService;

    @GetMapping("/search/errorCode")
    public ResponseEntity<ErrorDTO> searchByErrorCode(@RequestHeader("Error-Code") String errorCode, @RequestHeader("Accept-Language") String language) {

        // TODO: get error by code
        ErrorDTO error = errorService.findErrorByCode(errorCode);

        return ResponseEntity.ok(error);
    }

    @GetMapping("/search/keyword")
    public ErrorDTO searchByKeyword(@RequestHeader("Keyword") String keyword, @RequestHeader("Accept-Language") String language) {

        ErrorDTO error = new ErrorDTO();
        // TODO: get error by keyword
        return error;
    }


    @PostMapping("/showPageContent")
    public void showPage(@RequestHeader("Page-Name") String pageName) {

    }


    @PutMapping("/save")
    public ResponseEntity<String> update(@Valid @RequestBody AdminConfigDTO request) {
        Lookup root = convertor.convertToLookup(request);

        lookupService.updateLookups(root);


        return ResponseEntity.ok("Updated Successfully");
    }

    @GetMapping("/save")
    public ResponseEntity<AdminConfigDTO> get() {


        Lookup root = lookupService.getLookup();
        AdminConfigDTO dto = convertor.convertFromLookup(root, AdminConfigDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/saveStatus")
    public ResponseEntity<String> saveVatStatus(@Valid @RequestBody TaxpayerVatDTO request) {

        Lookup root = convertor.convertToLookup(request);
        taxpayerVatService.saveVatLookup(root);

        return ResponseEntity.ok("Status saved successfully");
    }

    @GetMapping("/getStatus")
    public ResponseEntity<String> getStatus(String code, String vat) {
        String status = taxpayerVatService.getClearanceStatus(code, vat);
        if (status == null || status.isEmpty()) {
            return ResponseEntity.badRequest().body("VAT not found");
        }
        return ResponseEntity.ok(status);
    }


}
