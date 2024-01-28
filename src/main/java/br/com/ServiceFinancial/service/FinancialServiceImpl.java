package br.com.ServiceFinancial.service;

import br.com.ServiceFinancial.dto.category.CategoryRequestDTO;
import br.com.ServiceFinancial.dto.category.CategoryResponseDTO;
import br.com.ServiceFinancial.dto.sub_category.SubCategoryRequestDTO;
import br.com.ServiceFinancial.dto.sub_category.SubCategoryResponseDTO;
import br.com.ServiceFinancial.dto.users.UserRequestDTO;
import br.com.ServiceFinancial.dto.users.UserResponseDTO;
import br.com.ServiceFinancial.service.category.CategoryService;
import br.com.ServiceFinancial.service.sub_category.SubCategoryService;
import br.com.ServiceFinancial.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialServiceImpl implements FinancialService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private SubCategoryService subCategoryService;

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

    @Override
    public UserResponseDTO createUser(UserRequestDTO request) {
        return userService.createUser(request);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        return userService.getUserById(id);
    }

    @Override
    public void deleteUserById(Long id) {
        userService.deleteUserById(id);
    }

    @Override
    public SubCategoryResponseDTO createSubCategory(SubCategoryRequestDTO request) {
        return subCategoryService.createSubCategory(request);
    }

    @Override
    public SubCategoryResponseDTO getSubCategoryById(Long id) {
        return subCategoryService.getSubCategoryById(id);
    }

    @Override
    public List<SubCategoryResponseDTO> getAllSubCategory() {
        return subCategoryService.getAllSubCategory();
    }

    @Override
    public void deleteSubCategory(Long id) {
        subCategoryService.deleteSubCategory(id);
    }

    @Override
    public SubCategoryResponseDTO updateSubCategoryById(Long id, SubCategoryRequestDTO request) {
        return subCategoryService.updateSubCategoryById(id, request);
    }
}
