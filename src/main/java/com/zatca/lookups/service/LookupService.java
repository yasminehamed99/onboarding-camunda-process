package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.request.RequestLookupDto;
import com.zatca.lookups.api.v1.request.RequestMetaDataDto;
import com.zatca.lookups.api.v1.response.ResponseLookupDto;
import com.zatca.lookups.entity.Lookup;
import com.zatca.lookups.entity.LookupMetaData;
import com.zatca.lookups.entity.LookupStatus;
import com.zatca.lookups.exception.NotFoundBusinessException;
import com.zatca.lookups.repository.LookupRepo;
import com.zatca.lookups.repository.MetaDataRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LookupService {

    @Autowired
    private LookupRepo lookupRepo;

    @Autowired
    private MetaDataRepo metaDataRepo;

    @Value("${root.admin.config.code}")
    private String adminConfigRootCode;

    @Value("${root.clearance.config.code}")
    private String clearanceConfigRootCode;

    public void createRoot(String code, String group) {
        Lookup lookup = new Lookup();
        lookup.setCode(code);
        lookup.setGroup(group);
        lookup.setLookupStatus(LookupStatus.ENABLED);

        lookupRepo.save(lookup);
    }

    /**
     * Update an old lookup with the provided requestLookupDto data
     *
     * @param requestLookupDto: RequestLookupDto
     */
    @Transactional(rollbackFor = Exception.class)
    public void update(RequestLookupDto requestLookupDto) {

        // Get the lookup to be updated
//        Lookup lookup = lookupRepo.findById(requestLookupDto.getId()).orElseThrow(()
//                -> new NotFoundBusinessException("Can't find the lookup lookup with id = " +
//                requestLookupDto.getId()));

        Lookup lookup = lookupRepo.findByCode(requestLookupDto.getCode()).orElseThrow(() -> new NotFoundBusinessException("Can't find the lookup with code: " + requestLookupDto.getCode()));

        // Get the parent lookup
        Lookup parentLookup = lookupRepo.findByCodeAndLookupStatus(requestLookupDto.getParentCode(),
                LookupStatus.ENABLED).orElseThrow(()
                -> new NotFoundBusinessException("Can't find the parent lookup with code = " +
                requestLookupDto.getParentCode()));

        lookup.setLookupStatus(LookupStatus.ENABLED);
        lookup.setParentLookup(parentLookup);
        lookup.setCode(requestLookupDto.getCode());

        metaDataRepo.deleteAllByLookupId(lookup.getId());

        // Save for the first time to get the sequence id
        lookup = lookupRepo.save(lookup);

        Lookup finalLookup = lookup;
        if (requestLookupDto.getMetaData() != null && !requestLookupDto.getMetaData().isEmpty()) {
            lookup.setLookupMetaData(requestLookupDto.getMetaData().stream().map(m ->
                            new LookupMetaData(m.getName(), m.getValue(), finalLookup)).
                    collect(Collectors.toList()));
        }

        // Save for the second time to persist the metadata with the created lookup
        lookupRepo.save(lookup);
    }

    @Transactional(rollbackFor = Exception.class)
    public void logicalDelete(String lookupCode) {

        // Get the lookup to be updated
        Lookup lookup = lookupRepo.findByCodeAndLookupStatus(lookupCode, LookupStatus.ENABLED)
                .orElseThrow(() -> new NotFoundBusinessException("Can't find the lookup lookup with code = " +
                        lookupCode));

        // Check if the lookup have one or more child throw an exception
        if (lookup.getChilds() != null && !lookup.getChilds().isEmpty()) {
            lookup.getChilds().parallelStream().forEach(l -> l.setLookupStatus(LookupStatus.DISABLED));
        }

        lookup.setLookupStatus(LookupStatus.DISABLED);

        lookupRepo.save(lookup);
    }

    /**
     * Create new lookup from RequestLookupDto
     *
     * @param requestLookupDto: RequestLookupDto
     */
    @Transactional(rollbackFor = Exception.class)
    public void create(RequestLookupDto requestLookupDto) {

        // Get the parent lookup
        Lookup parentLookup = lookupRepo.findByCodeAndLookupStatus(requestLookupDto.getParentCode(),
                LookupStatus.ENABLED).orElseThrow(()
                -> new NotFoundBusinessException("Can't find the parent lookup with code = " +
                requestLookupDto.getParentCode()));

        // Throw exception if lookup by same code is exists
        if (lookupRepo.existsByCode(requestLookupDto.getCode())) {
            throw new NotFoundBusinessException("Lookup with code = " +
                    requestLookupDto.getCode());
        }

        Lookup lookup = new Lookup();
        lookup.setParentLookup(parentLookup);
        lookup.setCode(requestLookupDto.getCode());
        lookup.setLookupStatus(LookupStatus.ENABLED);
        lookup.setGroup(requestLookupDto.getGroup());

        // Save for the first time to get the sequence id
        lookup = lookupRepo.save(lookup);

        Lookup finalLookup = lookup;
        if (requestLookupDto.getMetaData() != null && !requestLookupDto.getMetaData().isEmpty()) {
            lookup.setLookupMetaData(requestLookupDto.getMetaData().stream().map(m ->
                            new LookupMetaData(m.getName(), m.getValue(), finalLookup)).
                    collect(Collectors.toList()));
        }

        // Save for the second time to persist the metadata with the created lookup
        lookupRepo.save(lookup);
    }

    public ResponseLookupDto findFromCodeByDepth(int depth, String code) {

        // Find the root lookup and then take from there the other lookups based on the provided depth
        Lookup rootLookup = lookupRepo.findByCodeAndLookupStatus(code, LookupStatus.ENABLED).orElseThrow(()
                -> new NotFoundBusinessException("Can't find the lookup with lookup code = " +
                code));

        return rootLookup.convertToDto(depth);
    }

    public ResponseLookupDto findFromRootByDepth(int depth) {
        return findFromCodeByDepth(depth, "Root");
    }


    public void updateLookups(Lookup requestLookup) {
//        lookupRepo.deleteAll();

        Lookup lookup = lookupRepo.findByCode(requestLookup.getCode()).get();
        lookupRepo.delete(lookup);

        lookupRepo.save(requestLookup);

    }

    public Lookup getLookup() {
        return lookupRepo.findAll().get(0);
    }

    public String getMetaData(String lookupCode, String metaCode) {

        ResponseLookupDto lookupDto = findFromCodeByDepth(0, lookupCode);
        Map<String, String> metaDataDto = lookupDto.getMetaDataMap();
        if (metaDataDto.containsKey(metaCode)) {
            return metaDataDto.get(metaCode);
        }
        return null;
    }

    public Lookup findByRoot(String rootCode) {
        try {
            return lookupRepo.findByCode(rootCode).get();
        } catch (Exception e) {
            throw new NotFoundBusinessException("Lookup with root " + rootCode + " not found");
        }
    }


    @Transactional
    public void updateMetaData(String lookupCode, RequestMetaDataDto request) {

        request.getMetaData().forEach(m -> {

            LookupMetaData lookupMetaData = metaDataRepo.findByLookupCodeAndName(lookupCode, m.getName());

            if (lookupMetaData == null) {

                throw new NotFoundBusinessException("No Meta Data Found For Name: " + m.getName());
            }

            lookupMetaData.setValue(m.getValue());
            metaDataRepo.save(lookupMetaData);
        });

    }

    public void updateClearanceLookup(Lookup root) {

        try {
            Lookup lookup = lookupRepo.findByCode(root.getCode()).get();
            lookupRepo.delete(lookup);
            log.info("Saving Oneway Clearance Lookup");
            lookupRepo.save(root);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new NotFoundBusinessException(e.getMessage());
        }
    }

    public String findByNameAndValue(String lookupCode, String name, String value) {

        List<Lookup> lookup = lookupRepo.findByLookupMetaDataNameAndLookupMetaDataValueAndCodeLike(name, value, lookupCode);
        if (lookup == null || lookup.isEmpty()) {
            return "ENABLED";
        }
        for (LookupMetaData metaData : lookup.get(0).getLookupMetaData()) {
            if (metaData.getName().equalsIgnoreCase("clearanceStatus")) {
                return metaData.getValue();
            }
        }
        return "ENABLED";
    }


}
