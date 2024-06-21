package br.com.ServiceFinancial.controller;

import br.com.ServiceFinancial.dto.category.CategoryRequestDTO;
import br.com.ServiceFinancial.dto.category.CategoryResponseDTO;
import br.com.ServiceFinancial.service.FinancialService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {

    private final FinancialService financialService;

    @PostMapping(value = "/v1/category")
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(financialService.createCategory(request));
    }

    @GetMapping(value = "/v1/category/{userId}")
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategoryByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(financialService.getAllCategoryByUserId(userId));
    }

    @GetMapping(value = "/v1/category/{userId}/{categoryId}")
    public ResponseEntity<CategoryResponseDTO> getAllCategoryByUserIdAndCategoryId(@PathVariable("userId") Long userId, @PathVariable("categoryId") Long categoryId) {
        return ResponseEntity.status(HttpStatus.OK).body(financialService.getAllCategoryByUserIdAndCategoryId(userId, categoryId));
    }

    @PutMapping(value = "/v1/category/{userId}/{categoryId}")
    public ResponseEntity<CategoryResponseDTO> updateCategoryByUserId(@PathVariable("userId") Long userId,
                                                                      @PathVariable("categoryId") Long categoryId,
                                                                      @RequestBody CategoryRequestDTO request) {
        return ResponseEntity.status(HttpStatus.OK).body(financialService.updateCategoryByUserId(userId, categoryId, request));
    }

    @DeleteMapping(value = "/v1/category/{userId}/{categoryId}")
    public ResponseEntity<Void> deleteCategoryByUserId(@PathVariable("userId") Long userId, @PathVariable("categoryId") Long categoryId) {
        financialService.deleteCategoryByUserId(userId, categoryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
