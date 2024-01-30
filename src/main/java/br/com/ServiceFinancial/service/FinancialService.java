package br.com.ServiceFinancial.service;

import br.com.ServiceFinancial.dto.category.CategoryRequestDTO;
import br.com.ServiceFinancial.dto.category.CategoryResponseDTO;
import br.com.ServiceFinancial.dto.months.MonthsRequestDTO;
import br.com.ServiceFinancial.dto.months.MonthsResponseDTO;
import br.com.ServiceFinancial.dto.sub_category.SubCategoryRequestDTO;
import br.com.ServiceFinancial.dto.sub_category.SubCategoryResponseDTO;
import br.com.ServiceFinancial.dto.users.UserRequestDTO;
import br.com.ServiceFinancial.dto.users.UserResponseDTO;
import br.com.ServiceFinancial.dto.year.YearRequestDTO;
import br.com.ServiceFinancial.dto.year.YearResponseDTO;

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

    YearResponseDTO createYear(YearRequestDTO request);
    List<YearResponseDTO> createAllYear(List<YearRequestDTO> request);
    YearResponseDTO getYearById(Long id);
    List<YearResponseDTO> getAllYear();
    void deleteYearById(Long id);

    MonthsResponseDTO getMonthsById(Long id);
    List<MonthsResponseDTO> getAllMonths();
    List<MonthsResponseDTO> createAllMonths(List<MonthsRequestDTO> request);
}
