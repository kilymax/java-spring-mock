package com.example.JavaSpringMock.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PostBalancesResponseDTO {
    private String rqUID;
    private String clientId;
    private String account;
    private String currency;
    private BigDecimal balance;
    private BigDecimal maxLimit;
}
