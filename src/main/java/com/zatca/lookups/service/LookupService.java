package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.request.RequestLookupDto;
import com.zatca.lookups.api.v1.response.ResponseLookupDto;
import com.zatca.lookups.entity.Lookup;
import com.zatca.lookups.entity.LookupMetaData;
import com.zatca.lookups.entity.LookupStatus;
import com.zatca.lookups.exception.NotFoundBusinessException;
import com.zatca.lookups.repository.LookupRepo;
import com.zatca.lookups.repository.MetaDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class LookupService {

    @Autowired
    private LookupRepo lookupRepo;

    @Autowired
    private MetaDataRepo metaDataRepo;

    public void createRoot() {
        Lookup lookup = new Lookup();
        lookup.setCode("ROOT_CODE");
        lookup.setGroup("ROOT_GROUP");
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
        Lookup lookup = lookupRepo.findById(requestLookupDto.getId()).orElseThrow(()
                -> new NotFoundBusinessException("Can't find the lookup lookup with id = " +
                requestLookupDto.getId()));

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
        if(requestLookupDto.getMetaData() != null && !requestLookupDto.getMetaData().isEmpty()) {
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
        if(lookup.getChilds() != null && !lookup.getChilds().isEmpty()) {
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
        if(lookupRepo.existsByCode(requestLookupDto.getCode())) {
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
        if(requestLookupDto.getMetaData() != null && !requestLookupDto.getMetaData().isEmpty()) {
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
        return findFromCodeByDepth(depth, "ROOT_CODE");
    }
}
