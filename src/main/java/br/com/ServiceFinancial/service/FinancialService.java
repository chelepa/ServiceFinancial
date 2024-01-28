package br.com.ServiceFinancial.service;

import br.com.ServiceFinancial.dto.category.CategoryRequestDTO;
import br.com.ServiceFinancial.dto.category.CategoryResponseDTO;
import br.com.ServiceFinancial.dto.sub_category.SubCategoryRequestDTO;
import br.com.ServiceFinancial.dto.sub_category.SubCategoryResponseDTO;
import br.com.ServiceFinancial.dto.users.UserRequestDTO;
import br.com.ServiceFinancial.dto.users.UserResponseDTO;

import java.util.List;

public interface FinancialService {

    CategoryResponseDTO createCategory(CategoryRequestDTO request);
    CategoryResponseDTO getCategoryById(Long id);
    List<CategoryResponseDTO> getAllCategory();
    void deleteCategoryById(Long id);
    CategoryResponseDTO updateCategoryById(Long id, CategoryRequestDTO request);

    UserResponseDTO createUser(UserRequestDTO request);
    UserResponseDTO getUserById(Long id);
    void deleteUserById(Long id);

    SubCategoryResponseDTO createSubCategory(SubCategoryRequestDTO request);
    SubCategoryResponseDTO getSubCategoryById(Long id);
    List<SubCategoryResponseDTO> getAllSubCategory();
    void deleteSubCategory(Long id);
    SubCategoryResponseDTO updateSubCategoryById(Long id, SubCategoryRequestDTO request);
}
