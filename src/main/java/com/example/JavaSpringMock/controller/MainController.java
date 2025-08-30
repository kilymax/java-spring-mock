package com.example.JavaSpringMock.controller;

import com.example.JavaSpringMock.model.RequestDTO;
import com.example.JavaSpringMock.model.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class MainController {

    private Logger log = LoggerFactory.getLogger(MainController.class);

    ObjectMapper mapper = new ObjectMapper();

    @PostMapping(
            value = "/info/postBalances",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Object postBalances(@RequestBody RequestDTO requestDTO) {
        try {
            String clientId = requestDTO.getClientId();
            char firstDigit = clientId.charAt(0);
            String currency;
            BigDecimal maxLimit;
            BigDecimal balance;
            switch (firstDigit) {
                // homework 4:03:20
                case '8':
                    maxLimit = new BigDecimal(2000);
                    currency = "US";
                    balance = BigDecimal.valueOf(Math.random()).multiply(maxLimit);
                    break;
                case '9':
                    maxLimit = new BigDecimal(1000);
                    currency = "EU";
                    balance = BigDecimal.valueOf(Math.random()).multiply(maxLimit);
                    break;
                default:
                    maxLimit = new BigDecimal(10000);
                    currency = "RUB";
                    balance = BigDecimal.valueOf(Math.random()).multiply(maxLimit);
            }
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setRqUID(requestDTO.getRqUID());
            responseDTO.setClientId(clientId);
            responseDTO.setAccount(requestDTO.getAccount());
            responseDTO.setCurrency(currency);
            responseDTO.setBalance(balance);
            responseDTO.setMaxLimit(maxLimit);

            log.info("*** RequestDTO ***" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestDTO));
            log.info("*** ResponseDTO ***" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseDTO));

            return responseDTO;
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
