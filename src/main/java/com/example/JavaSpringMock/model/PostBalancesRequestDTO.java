package com.example.JavaSpringMock.model;

import lombok.*;

// magic lombok annotations
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostBalancesRequestDTO {
    private String rqUID;
    private String clientId;
    private String account;
    private String openDate;
    private String closeDate;
}
