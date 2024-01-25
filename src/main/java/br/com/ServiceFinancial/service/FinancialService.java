package br.com.ServiceFinancial.service;

import br.com.ServiceFinancial.dto.category.CategoryRequestDTO;
import br.com.ServiceFinancial.dto.category.CategoryResponseDTO;

import java.util.List;

public interface FinancialService {

    CategoryResponseDTO createCategory(CategoryRequestDTO request);

    CategoryResponseDTO getCategoryById(Long id);

    List<CategoryResponseDTO> getAllCategory();

    void deleteCategoryById(Long id);

    CategoryResponseDTO updateCategoryById(Long id, CategoryRequestDTO request);
}
