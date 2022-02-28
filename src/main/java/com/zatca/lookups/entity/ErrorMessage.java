package com.zatca.lookups.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ErrorMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "message", columnDefinition = "NVARCHAR(max)")
    private String message;

    @Column(name = "message_ar", columnDefinition = "NVARCHAR(max)")
    private String arabicMessage;

    @Column(name = "type")
    private String type;
}