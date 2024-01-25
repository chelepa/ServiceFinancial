package br.com.ServiceFinancial.controller;

import br.com.ServiceFinancial.dto.category.CategoryRequestDTO;
import br.com.ServiceFinancial.dto.category.CategoryResponseDTO;
import br.com.ServiceFinancial.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private FinancialService service;

    @PostMapping(value = "/v1/Category")
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCategory(request));
    }

    @GetMapping(value = "/v1/Category/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getCategoryById(id));
    }

    @GetMapping(value = "/v1/Category")
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategory(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllCategory());
    }

    @DeleteMapping(value = "/v1/Category/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable("id") Long id){
        service.deleteCategoryById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(value = "/v1/Category/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategoryById(@PathVariable("id") Long id, @RequestBody CategoryRequestDTO request){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateCategoryById(id, request));
    }
}
