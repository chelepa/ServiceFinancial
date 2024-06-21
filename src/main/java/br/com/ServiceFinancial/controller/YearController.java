package br.com.ServiceFinancial.controller;

import br.com.ServiceFinancial.dto.year.YearRequestDTO;
import br.com.ServiceFinancial.dto.year.YearResponseDTO;
import br.com.ServiceFinancial.service.FinancialService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class YearController {

    private final FinancialService financialService;

    @PostMapping(value = "/v1/year")
    public ResponseEntity<YearResponseDTO> createYear(@RequestBody YearRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(financialService.createYear(request));
    }
}
