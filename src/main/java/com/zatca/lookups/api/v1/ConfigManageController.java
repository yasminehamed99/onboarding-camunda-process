package com.zatca.lookups.api.v1;

import com.zatca.lookups.api.v1.dto.AdminConfigDTO;
import com.zatca.lookups.api.v1.dto.TaxpayerVatDTO;
import com.zatca.lookups.api.v1.dto.errorMessages.ErrorDTO;
import com.zatca.lookups.convertorEngine.ConvertorFacade;
import com.zatca.lookups.entity.Lookup;
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

   /* @PostMapping("/saveVat")
    public ResponseEntity<String> changeStatus(@Valid @RequestBody TaxpayerVatDTO request) {
        // TODO: get information by vat number and let user change status
        taxpayerVatService.saveVAT(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("VAT Saved Successfully");
    }*/

    @PostMapping("/showPageContent")
    public void showPage(@RequestHeader("Page-Name") String pageName) {

    }


    @PutMapping("/save")
    public ResponseEntity<String> update(@Valid @RequestBody AdminConfigDTO request) {
        Lookup root = convertor.convertToLookup(request);

        lookupService.updateLookups(root);
        AdminConfigDTO dto = convertor.convertFromLookup(root, AdminConfigDTO.class);

        return ResponseEntity.ok("Updated Successfully");
    }

    /*@GetMapping("/save")
    public ResponseEntity<AdminConfigDTO> find() {
        AdminConfigDTO dto = adminConfigService.findConfigurations();

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/getClearanceStatus")
    public ResponseEntity<String> getClearanceStatus() {

        String status = clearanceStatusService.findClearanceStatus();
        return ResponseEntity.ok(status);
    }

    @GetMapping("/getVatNumbers")
    public ResponseEntity<List<TaxpayerVatDTO>> getVat() {
        List<TaxpayerVatDTO> vatNumbers = taxpayerVatService.findVatNumbers();
        return ResponseEntity.ok(vatNumbers);
    }*/
}
