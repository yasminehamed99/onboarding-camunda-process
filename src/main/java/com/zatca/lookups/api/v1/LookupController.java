package com.zatca.lookups.api.v1;

import com.zatca.lookups.api.v1.request.RequestLookupDto;
import com.zatca.lookups.api.v1.response.ResponseLookupDto;
import com.zatca.lookups.service.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
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
        lookupService.createRoot();

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
}
