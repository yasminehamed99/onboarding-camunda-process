package com.zatca.lookups;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zatca.lookups.api.v1.request.RequestLookupDto;
import com.zatca.lookups.api.v1.request.RequestLookupMetaDataDto;
import com.zatca.lookups.entity.Lookup;

import java.util.ArrayList;
import java.util.List;

public interface IntegrationAbstractTest {

    default String makeItString(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(object);
    }

    default RequestLookupDto makeRandomLookupRequest(String parentCode) {
        RequestLookupDto dto = new RequestLookupDto();
        dto.setCode("NEW_LOOKUP_" + randomNum());
        dto.setGroup("NEW_LOOKUP_GROUP_" + randomNum());
        dto.setTitleAr("TITLE_AR_" + randomNum());
        dto.setTitleEn("TITLE_EN_" + randomNum());
        dto.setParentCode(parentCode);
        List<RequestLookupMetaDataDto> metaDataDtoList = new ArrayList<>();
        metaDataDtoList.add(new RequestLookupMetaDataDto("Key1", "Value1"));
        metaDataDtoList.add(new RequestLookupMetaDataDto("Key2", "Value2"));
        dto.setMetaData(metaDataDtoList);
        return dto;
    }

    default int randomNum() {
        return (int)Math.floor(Math.random()*(100000-1+1)+1);
    }
}
