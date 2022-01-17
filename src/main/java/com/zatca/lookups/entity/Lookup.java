package com.zatca.lookups.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zatca.lookups.api.v1.response.ResponseLookupDto;
import com.zatca.lookups.api.v1.response.ResponseLookupMetaDataDto;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "LOOKUP")
public class Lookup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "GROUP_NAME")
    private String group;

    @Column(name = "TITLE_EN")
    private String titleEn;

    @Column(name = "TITLE_AR")
    private String titleAr;

    @Column(name = "CODE")
    private String code;

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

    public String labelByLocal(Locale locale) {
        if (locale.toString().contains("en"))
            return this.titleEn;
        else
            return this.titleAr;
    }

    public ResponseLookupDto convertToDto(int depth) {

        long parentLookupId = 0;
        if(this.parentLookup != null)
            parentLookupId = this.parentLookup.getId();

        List<ResponseLookupMetaDataDto> metaDataDtoList = null;
        if(lookupMetaData != null && !lookupMetaData.isEmpty()) {
            metaDataDtoList = lookupMetaData.parallelStream().map(md -> md.convertToDto()).collect(Collectors.toList());
        }

        ResponseLookupDto dto = new ResponseLookupDto(this.group, this.titleAr, this.titleEn, this.code,
                parentLookupId, null, metaDataDtoList);

        if (depth > 0) {
            dto.setChilds(this.childs.stream().map(c -> c.convertToDto(depth - 1)).collect(Collectors.toList()));
        }

        return dto;
    }
}
