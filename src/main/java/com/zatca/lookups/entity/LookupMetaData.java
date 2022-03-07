package com.zatca.lookups.entity;

import com.zatca.lookups.api.v1.response.ResponseLookupMetaDataDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "LOOKUP_META_DATA")
public class LookupMetaData implements Serializable {

    public LookupMetaData(String name, String value, Lookup lookup) {
        this.name = name;
        this.value = value;
        this.lookup = lookup;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Value", nullable = false)
    private String value;

    @Column(name = "JavaType")
    private String type;

    @ManyToOne
    @JoinColumn(name = "lookupId", referencedColumnName = "Id")
    private Lookup lookup;

    @OneToOne(mappedBy = "lookupMetaData", cascade = CascadeType.ALL)
    private BigData bigData;

    public ResponseLookupMetaDataDto convertToDto() {
        return new ResponseLookupMetaDataDto(name, value);
    }
}
