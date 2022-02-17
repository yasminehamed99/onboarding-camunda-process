package com.zatca.lookups.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zatca.lookups.api.v1.response.ResponseLookupDto;
import com.zatca.lookups.api.v1.response.ResponseLookupMetaDataDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Setter
@Getter
@Entity(name = "LOOKUP")
public class Lookup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIELD_NAME")
    private String fieldName;

    @Column(name = "GROUP_NAME")
    private String group;

    @Column(name = "CODE", unique = true)
    private String code;

    @Column(name = "JavaType")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REF_ID")
    @JsonBackReference
    private Lookup parentLookup;

    @OneToMany(mappedBy = "parentLookup", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Lookup> childs;

    @Enumerated(EnumType.STRING)
    private LookupStatus lookupStatus;

    @OneToMany(mappedBy = "lookup", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LookupMetaData> lookupMetaData;

    public ResponseLookupDto convertToDto(int depth) {

        long parentLookupId = 0;
        if(this.parentLookup != null)
            parentLookupId = this.parentLookup.getId();

        List<ResponseLookupMetaDataDto> metaDataDtoList = null;
        if(lookupMetaData != null && !lookupMetaData.isEmpty()) {
            metaDataDtoList = lookupMetaData.parallelStream().map(LookupMetaData::convertToDto).collect(Collectors.toList());
        }

        ResponseLookupDto dto = new ResponseLookupDto(this.id, this.group, this.code,
                parentLookupId, null, this.lookupMetaData.stream().collect(Collectors.toMap(LookupMetaData::getName, LookupMetaData::getValue)));

        if (depth > 0) {
            dto.setChilds(this.childs.stream().map(c -> c.convertToDto(depth - 1)).collect(Collectors.toList()));
        }

        return dto;
    }

    @Override
    public String toString() {
        return "Lookup{" +
                "group='" + group + '\'' +
                ", code='" + code + '\'' +
                ", lookupStatus=" + lookupStatus +
                '}';
    }
}
