package br.com.ServiceFinancial.controller;

import br.com.ServiceFinancial.dto.expenses_and_income.ExpensesAndIncomeRequestDTO;
import br.com.ServiceFinancial.dto.expenses_and_income.ExpensesAndIncomeResponseDTO;
import br.com.ServiceFinancial.dto.sub_category.SubCategoryRequestDTO;
import br.com.ServiceFinancial.dto.sub_category.SubCategoryResponseDTO;
import br.com.ServiceFinancial.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpensesAndIncomeController {

    @Autowired
    private FinancialService service;

    @PostMapping(value = "/v1/ExpensesAndIncome")
    public ResponseEntity<ExpensesAndIncomeResponseDTO> createExpensesAndIncome(@RequestBody ExpensesAndIncomeRequestDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createExpensesAndIncome(request));
    }

    @GetMapping(value = "/v1/ExpensesAndIncome/{id}")
    public ResponseEntity<ExpensesAndIncomeResponseDTO> getExpensesAndIncomeById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getExpensesAndIncomeById(id));
    }

    @PutMapping(value = "/v1/ExpensesAndIncome/{id}")
    public ResponseEntity<ExpensesAndIncomeResponseDTO> updateExpensesAndIncomeById(@PathVariable("id") Long id, @RequestBody ExpensesAndIncomeRequestDTO request){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateExpensesAndIncomeById(id, request));
    }

    @DeleteMapping(value = "/v1/ExpensesAndIncome/{id}")
    public ResponseEntity<Void> deleteExpensesAndIncome(@PathVariable("id") Long id){
        service.deleteExpensesAndIncome(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
