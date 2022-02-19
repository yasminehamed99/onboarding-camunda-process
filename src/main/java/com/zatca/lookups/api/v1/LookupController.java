package com.zatca.lookups.api.v1;

import com.zatca.lookups.api.v1.dto.AdminConfigDTO;
import com.zatca.lookups.api.v1.dto.ClearanceStatusDTO;
import com.zatca.lookups.api.v1.request.RequestLookupDto;
import com.zatca.lookups.api.v1.response.ResponseLookupDto;
import com.zatca.lookups.convertorEngine.ConvertorFacade;
import com.zatca.lookups.entity.Lookup;
import com.zatca.lookups.repository.LookupRepo;
import com.zatca.lookups.service.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Validated
@RestController
@RequestMapping("/api/lookups/v1")
public class LookupController {

    @Autowired
    private LookupService lookupService;

    @Autowired
    private ConvertorFacade convertor;

    @Value("${root.admin.config.code}")
    private String adminConfigRootCode;

    @Value("${root.admin.config.group}")
    private String adminConfigRootGroup;

    @Value("${root.clearance.config.code}")
    private String clearanceConfigRootCode;

    @Value("${root.clearance.config.group}")
    private String clearanceConfigRootGroup;

    @Autowired
    private LookupRepo lookupRepo;

    @GetMapping("rootLookupByDepth")
    public ResponseEntity<ResponseLookupDto> findRoot(int depth) {
        ResponseLookupDto responseLookupDto = lookupService.findFromRootByDepth(depth);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseLookupDto);
    }

    @GetMapping("lookupByCodeAndDepth")
    public ResponseEntity<ResponseLookupDto> findByCodeAndDepth(int depth, @Valid
                        @NotBlank(message = "Lookup code is mandatory") String lookupCode) {

        ResponseLookupDto responseLookupDto = lookupService.findFromCodeByDepth(depth, lookupCode);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseLookupDto);
    }

    @GetMapping("lookupByCode")
    public ResponseEntity<ResponseLookupDto> findByCode(@Valid @NotBlank(message = "Lookup code is mandatory")
                                                                    String lookupCode) {
        ResponseLookupDto responseLookupDto = lookupService.findFromCodeByDepth(0, lookupCode);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseLookupDto);
    }

    @PostMapping("rootLookup")
    public ResponseEntity<String> createRootLookup() {
        lookupService.createRoot("Root", "Root-Group");

        return ResponseEntity.status(HttpStatus.CREATED).body("New lookup saved successfully");
    }

    @PostMapping("lookup")
    public ResponseEntity<String> createNewLookup(@Valid @RequestBody RequestLookupDto requestLookupDto) {
        lookupService.create(requestLookupDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("New lookup saved successfully");
    }

    @PutMapping("lookup")
    public ResponseEntity<String> updateOldLookup(@Valid @RequestBody RequestLookupDto requestLookupDto) {

        if(requestLookupDto.getId() == null || requestLookupDto.getId() == 0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id is mandatory to update the lookup");

        lookupService.update(requestLookupDto);

        return ResponseEntity.status(HttpStatus.OK).body("New lookup saved successfully");
    }

    @DeleteMapping("lookup")
    public ResponseEntity<String> logicalDeleteOldLookup(@Valid
                                                  @NotBlank(message = "Lookup code can't be null or empty")
                                                  String code) {

        lookupService.logicalDelete(code);
        return ResponseEntity.status(HttpStatus.OK).body("Lookup with code = " + code + " " +
                "has been deleted successfully");
    }

    @GetMapping("/getMetaData")
    public ResponseEntity<String> getMetaData(@Valid  @NotBlank(message = "Lookup code can't be null or empty") String lookupCode,
                                              @Valid  @NotBlank(message = "Meta Data name can't be null or empty") String metaName) {
        String metaDataValue = lookupService.getMetaData(lookupCode, metaName);
        if (metaDataValue == null || metaDataValue.isEmpty()) {
            return ResponseEntity.badRequest().body(metaName + " code not found");
        }
        return ResponseEntity.ok(metaDataValue);
    }

    @PutMapping("/save")
    public ResponseEntity<String> update(@Valid @RequestBody AdminConfigDTO request) {
        Lookup root = convertor.convertToLookup(request, adminConfigRootGroup, adminConfigRootCode);

        lookupService.updateLookups(root);

        return ResponseEntity.ok("Updated Successfully");
    }

    @GetMapping("/save")
    public ResponseEntity<AdminConfigDTO> get() {

//        Lookup root = lookupService.getLookup();
        Lookup root = lookupRepo.findByCode("Root-Admin-Config").get();
        AdminConfigDTO dto = convertor.convertFromLookup(root, AdminConfigDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/saveStatus")
    public ResponseEntity<String> saveStatus(@RequestBody ClearanceStatusDTO request) {

        Lookup root = convertor.convertToLookup(request, clearanceConfigRootGroup, clearanceConfigRootCode);
        lookupService.updateLookups(root);
        return ResponseEntity.ok("Saved");
    }


}
