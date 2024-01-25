package br.com.ServiceFinancial.service;

import br.com.ServiceFinancial.dto.category.CategoryRequestDTO;
import br.com.ServiceFinancial.dto.category.CategoryResponseDTO;
import br.com.ServiceFinancial.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialServiceImpl implements FinancialService {

    @Autowired
    private CategoryService categoryService;

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO request) {
        return categoryService.createCategory(request);
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {
        return categoryService.getCategoryById(id);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryService.deleteCategoryById(id);
    }

    @Override
    public CategoryResponseDTO updateCategoryById(Long id, CategoryRequestDTO request) {
        return categoryService.updateCategoryById(id, request);
    }
}
