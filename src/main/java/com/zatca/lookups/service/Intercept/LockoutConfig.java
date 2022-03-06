package com.zatca.lookups.service.Intercept;

import com.zatca.lookups.api.v1.dto.LockoutConfigDto;
import com.zatca.lookups.entity.Lookup;
import com.zatca.lookups.entity.LookupMetaData;
import com.zatca.lookups.repository.LookupRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component("LockoutConfig")
@Slf4j
public class LockoutConfig implements LookupInterceptor {

    @Autowired
    private LookupRepo lookupRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${root.admin.config.code}")
    private String adminConfigRootCode;

    @Value("${devPortal.url}")
    private String devPortalUrl;

    @Override
    public void intercept(Lookup lookup) {

        Optional<Lookup> oldLookup = lookupRepo.findByCode("Root-Admin-Config-developerPortal-accountLock");
        if (oldLookup.isPresent()) {
            return;
        }
        List<LookupMetaData> oldMetaData = oldLookup.get().getLookupMetaData();
        List<LookupMetaData> newMetaData =  null; //lookup.getLookupMetaData();

        for (Lookup l : lookup.getChilds()) {
            if (l.getCode().equalsIgnoreCase("Root-Admin-Config-developerPortal")) {
                for ( Lookup l1 : l.getChilds()) {
                    if (l1.getCode().equalsIgnoreCase("Root-Admin-Config-developerPortal-accountLock")) {
                        newMetaData = l1.getLookupMetaData();
                    }
                }
            }
        }
        int old = 0;

        for(LookupMetaData m : oldMetaData) {
            if (m.getName().equalsIgnoreCase("numOfIncorrectPasswordAttemp")) {
                old = Integer.parseInt(m.getValue());
            }
        }

        int newMeta = 0;
        for (LookupMetaData m : newMetaData) {
            if (m.getName().equalsIgnoreCase("numOfIncorrectPasswordAttemp")) {
                newMeta = Integer.parseInt(m.getValue());
            }
        }


        if (old != newMeta) {

            LockoutConfigDto lockoutConfigDto = new LockoutConfigDto();
            lockoutConfigDto.setNumOfAttempts(newMeta);
            HttpEntity<LockoutConfigDto> request = new HttpEntity<>(lockoutConfigDto);
            try {

                ResponseEntity<String> response = restTemplate.postForEntity(devPortalUrl,request, String.class);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }

    }
}
