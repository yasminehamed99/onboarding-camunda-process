package com.zatca.lookups.service.Intercept;

import com.zatca.lookups.api.v1.dto.LockoutConfigDto;
import com.zatca.lookups.api.v1.dto.LockoutTimeConfigDto;
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

@Component("AccountLockoutTimeConfig")
@Slf4j
public class AccountLockoutTimeConfig implements LookupInterceptor {

    @Autowired
    private LookupRepo lookupRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${root.admin.config.code}")
    private String adminConfigRootCode;

    @Value("${devPortal.timeConfig.url}")
    private String devPortalUrl;

    @Override
    public void intercept(Lookup lookup) {

        Lookup oldLookup = lookupRepo.findByCode("Root-Admin-Config-developerPortal-accountLock").get();
        List<LookupMetaData> oldMetaData = oldLookup.getLookupMetaData();
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
        String oldTimePeriod = null;
        int oldValue = 0;

        for(LookupMetaData m : oldMetaData) {
            if (m.getName().equalsIgnoreCase("timePeriod")) {
                oldTimePeriod = m.getValue();
            }
            if (m.getName().equalsIgnoreCase("value")) {
                oldValue = Integer.parseInt(m.getValue());
            }
        }

        String newTimePeriod = null;
        int newValue = 0;
        for (LookupMetaData m : newMetaData) {
            if (m.getName().equalsIgnoreCase("timePeriod")) {
                newTimePeriod = m.getValue();
            }
            if (m.getName().equalsIgnoreCase("value")) {
                newValue = Integer.parseInt(m.getValue());
            }
        }

        log.debug("old value: " + oldValue);
        log.debug("old time period: " + oldTimePeriod);

        log.debug("new value: " + newValue);
        log.debug("new time period: " + newTimePeriod);

        if (!oldTimePeriod.equals(newTimePeriod)  || oldValue != newValue) {

            int timeInSeconds = 0;

            if (newTimePeriod.equalsIgnoreCase("days")) {
                timeInSeconds = newValue * 86400;
            } else if (newTimePeriod.equalsIgnoreCase("hours")) {
                timeInSeconds = newValue * 3600;
            } else if (newTimePeriod.equalsIgnoreCase("minutes")) {
                timeInSeconds = newValue * 60;
            } else if (newTimePeriod.equalsIgnoreCase("seconds")) {
                timeInSeconds = newValue;
            }

            LockoutTimeConfigDto lockoutTimeConfigDto = new LockoutTimeConfigDto();
            lockoutTimeConfigDto.setTimePeriod(newTimePeriod);
            lockoutTimeConfigDto.setValue(timeInSeconds);
            HttpEntity<LockoutTimeConfigDto> request = new HttpEntity<>(lockoutTimeConfigDto);
            try {
                ResponseEntity<String> response = restTemplate.postForEntity(devPortalUrl,request, String.class);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }

    }
}
