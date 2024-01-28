package br.com.ServiceFinancial.controller;

import br.com.ServiceFinancial.dto.sub_category.SubCategoryRequestDTO;
import br.com.ServiceFinancial.dto.sub_category.SubCategoryResponseDTO;
import br.com.ServiceFinancial.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubCategoryController {

    @Autowired
    private FinancialService service;

    @PostMapping(value = "/v1/SubCategory")
    public ResponseEntity<SubCategoryResponseDTO> createSubCategory(@RequestBody SubCategoryRequestDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createSubCategory(request));
    }

    @GetMapping(value = "/v1/SubCategory/{id}")
    public ResponseEntity<SubCategoryResponseDTO> getSubCategoryById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getSubCategoryById(id));
    }

    @GetMapping(value = "/v1/SubCategory")
    public ResponseEntity<List<SubCategoryResponseDTO>> getAllSubCategory(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllSubCategory());
    }

    @DeleteMapping(value = "/v1/SubCategory/{id}")
    public ResponseEntity<Void> deleteSubCategory(@PathVariable("id") Long id){
        service.deleteSubCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(value = "/v1/SubCategory/{id}")
    public ResponseEntity<SubCategoryResponseDTO> updateSubCategoryById(@PathVariable("id") Long id, @RequestBody SubCategoryRequestDTO request){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateSubCategoryById(id, request));
    }
}
