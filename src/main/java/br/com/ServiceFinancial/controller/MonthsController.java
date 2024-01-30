package br.com.ServiceFinancial.controller;

import br.com.ServiceFinancial.dto.months.MonthsResponseDTO;
import br.com.ServiceFinancial.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MonthsController {

    @Autowired
    private FinancialService service;

    @GetMapping(value = "/v1/Months/{id}")
    public ResponseEntity<MonthsResponseDTO> getMonthsById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getMonthsById(id));
    }

    @GetMapping(value = "/v1/Months")
    public ResponseEntity<List<MonthsResponseDTO>> getAllMonths(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllMonths());
    }
}
