package com.zatca.lookups.entity.configuration.errorMessages;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Error {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "ErrorCode")
    private String errorCode;
    @Column(name = "ErrorMessage")
    private String errorMessage;
}