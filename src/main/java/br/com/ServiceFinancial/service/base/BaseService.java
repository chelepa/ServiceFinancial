package br.com.ServiceFinancial.service.base;

import br.com.ServiceFinancial.entity.*;
import br.com.ServiceFinancial.exceptions.*;
import br.com.ServiceFinancial.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private YearRepository yearRepository;

    @Autowired
    private MonthsRepository monthsRepository;

    @Autowired
    private ExpensesAndIncomeRepository expensesAndIncomeRepository;

    protected CategoryEntity saveCategory(CategoryEntity entity){
        return categoryRepository.save(entity);
    }

    protected CategoryEntity searchCategoryById(Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(String.format("Category Not Found - Id: [%s] ", id)));
    }

    protected List<CategoryEntity> searchAllCategory(){
        return categoryRepository.findAll();
    }

    protected void removeCategory(CategoryEntity entity) {
        categoryRepository.delete(entity);
    }

    protected UserEntity saveUser(UserEntity entity){
        return userRepository.save(entity);
    }

    protected UserEntity searchUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(String.format("User Not Found - Id: [%s] ", id)));
    }

    protected void removeUser(UserEntity entity) {
        userRepository.delete(entity);
    }

    protected SubCategoryEntity saveSubCategory(SubCategoryEntity entity){
        return subCategoryRepository.save(entity);
    }

    protected SubCategoryEntity searchSubCategory(Long id){
        return subCategoryRepository.findById(id).orElseThrow(() -> new SubCategoryNotFoundException(String.format("Sub Category Not Found - Id: [%s] ", id)));
    }

    protected List<SubCategoryEntity> searchAllSubCategory(){
        return subCategoryRepository.findAll();
    }

    protected void removeSubCategory(SubCategoryEntity entity) {
        subCategoryRepository.delete(entity);
    }

    protected YearUserEntity saveYear(YearUserEntity entity) {
        return yearRepository.save(entity);
    }

    protected YearUserEntity searchYearById(Long id) {
        return yearRepository.findById(id).orElseThrow(() -> new YearNotFoundException(String.format("Year Not Found - Id: [%s] ", id)));
    }

    protected List<YearUserEntity> searchAllYear() {
        return yearRepository.findAll();
    }

    protected YearUserEntity searchYearByYearAndUserId(Long year, Long userId) {
        return yearRepository.findByYearAndUser_id(year, userId).orElseThrow(() -> new YearNotFoundException(String.format("Year Not Found - Year: [%s], UserId: [%s] ", year, userId)));
    }

    protected void removeYear(YearUserEntity entity) {
        yearRepository.delete(entity);
    }

    protected MonthsUserEntity searchMonthsById(Long id) {
        return monthsRepository.findById(id).orElseThrow(() -> new MonthsNotFoundException(String.format("Months Not Found - Id: [%s] ", id)));
    }

    protected List<MonthsUserEntity> searchAllMonths() {
        return monthsRepository.findAll();
    }

    protected MonthsUserEntity searchMonthsByNameAndYearAndUserId(String name, Long year, Long userId) {
        return monthsRepository.findByNameAndYear_yearAndYear_user_id(name, year, userId).orElseThrow(() -> new MonthsNotFoundException(String.format("Months Not Found - Name: [%s], Year: [%s], UserId: [%s] ", name, year, userId)));
    }

    protected ExpensesAndIncomeEntity saveExpensesAndIncome(ExpensesAndIncomeEntity entity) {
        return expensesAndIncomeRepository.save(entity);
    }

    protected ExpensesAndIncomeEntity searchExpensesAndIncome(Long id) {
        return expensesAndIncomeRepository.findById(id).orElseThrow(() -> new ExpensesAndIncomeNotFoundException(String.format("ExpensesAndIncome Not Found - Id: [%s] ", id)));
    }

    protected void removeExpensesAndIncome(ExpensesAndIncomeEntity entity) {
        expensesAndIncomeRepository.delete(entity);
    }
}
