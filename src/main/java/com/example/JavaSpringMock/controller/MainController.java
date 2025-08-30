package com.example.JavaSpringMock.controller;

import com.example.JavaSpringMock.model.GetClientIdResponseDTO;
import com.example.JavaSpringMock.model.PostBalancesRequestDTO;
import com.example.JavaSpringMock.model.PostBalancesResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class MainController {

    private Logger log = LoggerFactory.getLogger(MainController.class);

    ObjectMapper mapper = new ObjectMapper();

    @GetMapping(path = "/info/clients/{clientId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Object getClientId(@PathVariable String clientId) {
        try {
            GetClientIdResponseDTO getClientIdResponseDTO = new GetClientIdResponseDTO();
            getClientIdResponseDTO.setClientId(clientId);
            String clientName;
            BigDecimal balance;
            switch (clientId.charAt(0)) {
                case '1':
                    clientName = "Keanu Reeves";
                    balance = BigDecimal.valueOf(Math.random() * 500000);
                    break;
                case '2':
                    clientName = "Ilya Kochurov";
                    balance = BigDecimal.valueOf(Math.random() * 50000);
                    break;
                case '3':
                    clientName = "Monstero Ducati";
                    balance = BigDecimal.valueOf(696);
                    break;
                case '4':
                    clientName = "Kawa Ersh";
                    balance = BigDecimal.valueOf(649);
                    break;
                default:
                    clientName = "unknown";
                    balance = BigDecimal.valueOf(50);
            }
            getClientIdResponseDTO.setClientName(clientName);
            getClientIdResponseDTO.setBalance(balance);

            log.info("*** GetClientIdResponseDTO ***" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getClientIdResponseDTO));

            return getClientIdResponseDTO;

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping(
            value = "/info/postBalances",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Object postBalances(@RequestBody PostBalancesRequestDTO postBalancesRequestDTO) {
        try {
            String clientId = postBalancesRequestDTO.getClientId();
            char firstDigit = clientId.charAt(0);
            String currency;
            BigDecimal maxLimit;
            BigDecimal balance;
            switch (firstDigit) {
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
            PostBalancesResponseDTO postBalancesResponseDTO = new PostBalancesResponseDTO();
            postBalancesResponseDTO.setRqUID(postBalancesRequestDTO.getRqUID());
            postBalancesResponseDTO.setClientId(clientId);
            postBalancesResponseDTO.setAccount(postBalancesRequestDTO.getAccount());
            postBalancesResponseDTO.setCurrency(currency);
            postBalancesResponseDTO.setBalance(balance);
            postBalancesResponseDTO.setMaxLimit(maxLimit);

            log.info("*** postBalancesRequestDTO ***" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(postBalancesRequestDTO));
            log.info("*** PostBalancesResponseDTO ***" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(postBalancesResponseDTO));

            return postBalancesResponseDTO;
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
