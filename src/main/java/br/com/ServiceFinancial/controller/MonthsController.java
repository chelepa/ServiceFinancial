package br.com.ServiceFinancial.controller;

import br.com.ServiceFinancial.dto.months.MonthsRequestDTO;
import br.com.ServiceFinancial.dto.months.MonthsResponseDTO;
import br.com.ServiceFinancial.dto.year.YearRequestDTO;
import br.com.ServiceFinancial.dto.year.YearResponseDTO;
import br.com.ServiceFinancial.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MonthsController {

    @Autowired
    private FinancialService service;

    @PostMapping(value = "/v1/Months")
    public ResponseEntity<List<MonthsResponseDTO>> createMonths(@RequestBody List<MonthsRequestDTO> request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAllMonths(request));
    }

    @GetMapping(value = "/v1/Months/{id}")
    public ResponseEntity<MonthsResponseDTO> getMonthsById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getMonthsById(id));
    }

    @GetMapping(value = "/v1/Months")
    public ResponseEntity<List<MonthsResponseDTO>> getAllMonths(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllMonths());
    }
}
