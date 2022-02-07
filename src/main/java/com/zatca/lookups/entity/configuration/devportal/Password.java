package com.zatca.lookups.entity.configuration.devportal;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Password {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "Length")
    private long length;
    @Column(name = "minNumOfLowerCase")
    private long minNumOfLowerCase;
    @Column(name = "Min_Num_Of_Upper_Case")
    private long minNumOfUpperCase;
    @Column(name = "Min_Num_Of_Numbers")
    private long minNumOfNumbers;
    @Column(name = "Min_Num_Of_Symbols")
    private long minNumOfSymbols;

    @OneToOne(mappedBy = "password")
    private DevPortal devPortal;
}
