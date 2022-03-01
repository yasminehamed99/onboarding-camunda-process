package com.zatca.lookups.entity;

import com.zatca.lookups.api.v1.dto.errorMessages.ErrorDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class ErrorMessage {

    public ErrorMessage(ErrorDTO dto) {

        this.code = dto.getCode();
        this.message = dto.getMessage();
        this.arabicMessage = dto.getArabicMessage();
        this.type = dto.getType();

    }

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