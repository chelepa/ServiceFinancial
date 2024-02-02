package br.com.ServiceFinancial.service;

import br.com.ServiceFinancial.dto.category.CategoryRequestDTO;
import br.com.ServiceFinancial.dto.category.CategoryResponseDTO;
import br.com.ServiceFinancial.dto.expenses_and_income.ExpensesAndIncomeRequestDTO;
import br.com.ServiceFinancial.dto.expenses_and_income.ExpensesAndIncomeResponseDTO;
import br.com.ServiceFinancial.dto.months.MonthsResponseDTO;
import br.com.ServiceFinancial.dto.sub_category.SubCategoryRequestDTO;
import br.com.ServiceFinancial.dto.sub_category.SubCategoryResponseDTO;
import br.com.ServiceFinancial.dto.users.UserRequestDTO;
import br.com.ServiceFinancial.dto.users.UserResponseDTO;
import br.com.ServiceFinancial.dto.year.YearRequestDTO;
import br.com.ServiceFinancial.dto.year.YearResponseDTO;
import br.com.ServiceFinancial.service.category.CategoryService;
import br.com.ServiceFinancial.service.expenses_and_income.ExpensesAndIncomeService;
import br.com.ServiceFinancial.service.months.MonthsService;
import br.com.ServiceFinancial.service.sub_category.SubCategoryService;
import br.com.ServiceFinancial.service.user.UserService;
import br.com.ServiceFinancial.service.year.YearService;
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

    @Autowired
    private YearService yearService;

    @Autowired
    private MonthsService monthsService;

    @Autowired
    private ExpensesAndIncomeService expensesAndIncomeService;

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

    @Override
    public YearResponseDTO createYear(YearRequestDTO request) {
        return yearService.createYear(request);
    }

    @Override
    public List<YearResponseDTO> createAllYear(List<YearRequestDTO> request) {
        return yearService.createAllYear(request);
    }

    @Override
    public YearResponseDTO getYearById(Long id) {
        return yearService.getYearById(id);
    }

    @Override
    public List<YearResponseDTO> getAllYear() {
        return yearService.getAllYear();
    }

    @Override
    public void deleteYearById(Long id) {
        yearService.deleteYearById(id);
    }

    @Override
    public MonthsResponseDTO getMonthsById(Long id) {
        return monthsService.getMonthsById(id);
    }

    @Override
    public List<MonthsResponseDTO> getAllMonths() {
        return monthsService.getAllMonths();
    }

    @Override
    public List<ExpensesAndIncomeResponseDTO> createAllExpensesAndIncome(List<ExpensesAndIncomeRequestDTO> request) {
        return expensesAndIncomeService.createAllExpensesAndIncome(request);
    }

    @Override
    public ExpensesAndIncomeResponseDTO createExpensesAndIncome(ExpensesAndIncomeRequestDTO request) {
        return expensesAndIncomeService.createExpensesAndIncome(request);
    }

    @Override
    public ExpensesAndIncomeResponseDTO getExpensesAndIncomeById(Long id) {
        return expensesAndIncomeService.getExpensesAndIncomeById(id);
    }

    @Override
    public ExpensesAndIncomeResponseDTO updateExpensesAndIncomeById(Long id, ExpensesAndIncomeRequestDTO request) {
        return expensesAndIncomeService.updateExpensesAndIncomeById(id, request);
    }

    @Override
    public void deleteExpensesAndIncome(Long id) {
        expensesAndIncomeService.deleteExpensesAndIncome(id);
    }
}
