package com.example.JavaSpringMock.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GetClientIdResponseDTO {
    private String clientId;
    private String clientName;
    private BigDecimal balance;
}
