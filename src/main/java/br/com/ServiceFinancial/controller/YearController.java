package br.com.ServiceFinancial.controller;

import br.com.ServiceFinancial.dto.year.YearRequestDTO;
import br.com.ServiceFinancial.dto.year.YearResponseDTO;
import br.com.ServiceFinancial.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class YearController {

    @Autowired
    private FinancialService service;

    @PostMapping(value = "/v1/Year")
    public ResponseEntity<YearResponseDTO> createYear(@RequestBody YearRequestDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createYear(request));
    }

    @GetMapping(value = "/v1/Year/{id}")
    public ResponseEntity<YearResponseDTO> getYearById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getYearById(id));
    }

    @GetMapping(value = "/v1/Year")
    public ResponseEntity<List<YearResponseDTO>> getAllYear(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllYear());
    }

    @DeleteMapping(value = "/v1/Year/{id}")
    public ResponseEntity<Void> deleteYearById(@PathVariable("id") Long id){
        service.deleteYearById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
