package com.zatca.lookups.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "BIG_DATA")
public class BigData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Lob
    @Column(name = "Data", columnDefinition = "nvarchar(max)")
    private String data;

    @OneToOne
    @JoinColumn(name = "metadata", referencedColumnName = "Id")
    private LookupMetaData lookupMetaData;

    public BigData(String data, LookupMetaData lookupMetaData) {
        this.data = data;
        this.lookupMetaData = lookupMetaData;
    }
}
