package br.com.ServiceFinancial.controller;

import br.com.ServiceFinancial.dto.sub_category.SubCategoryRequestDTO;
import br.com.ServiceFinancial.dto.sub_category.SubCategoryResponseDTO;
import br.com.ServiceFinancial.service.FinancialService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SubCategoryController {

    private final FinancialService financialService;

    @PostMapping(value = "/v1/sub/category")
    public ResponseEntity<SubCategoryResponseDTO> createSubCategory(@RequestBody SubCategoryRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(financialService.createSubCategory(request));
    }

    @GetMapping(value = "/v1/sub/category/{userId}/{categoryId}")
    public ResponseEntity<List<SubCategoryResponseDTO>> getAllSubCategoryByUserId(@PathVariable("userId") Long userId,
                                                                                  @PathVariable("categoryId") Long categoryId) {
        return ResponseEntity.status(HttpStatus.OK).body(financialService.getAllSubCategoryByUserId(userId, categoryId));
    }

    @GetMapping(value = "/v1/sub/category/{userId}/{categoryId}/{subCategoryId}")
    public ResponseEntity<SubCategoryResponseDTO> getSubCategoryByUserIdAndCategoryIdAndSubCategoryId(@PathVariable("userId") Long userId,
                                                                                                      @PathVariable("categoryId") Long categoryId,
                                                                                                      @PathVariable("subCategoryId") Long subCategoryId) {
        return ResponseEntity.status(HttpStatus.OK).body(financialService.GetSubCategoryByUserIdAndCategoryIdAndSubCategoryId(userId, categoryId, subCategoryId));
    }

    @PutMapping(value = "/v1/sub/category/{userId}/{categoryId}/{subCategoryId}")
    public ResponseEntity<SubCategoryResponseDTO> updateSubCategoryByUserId(@PathVariable("userId") Long userId,
                                                                            @PathVariable("categoryId") Long categoryId,
                                                                            @PathVariable("subCategoryId") Long subCategoryId,
                                                                            @RequestBody SubCategoryRequestDTO request) {
        return ResponseEntity.status(HttpStatus.OK).body(financialService.updateSubCategoryByUserId(userId, categoryId, subCategoryId, request));
    }

    @DeleteMapping(value = "/v1/sub/category/{userId}/{categoryId}/{subCategoryId}")
    public ResponseEntity<Void> deleteSubCategoryByUserId(@PathVariable("userId") Long userId,
                                                          @PathVariable("categoryId") Long categoryId,
                                                          @PathVariable("subCategoryId") Long subCategoryId) {
        financialService.deleteSubCategoryByUserId(userId, categoryId, subCategoryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
