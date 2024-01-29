package br.com.ServiceFinancial.service.base;

import br.com.ServiceFinancial.entity.*;
import br.com.ServiceFinancial.exceptions.CategoryNotFoundException;
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
        return userRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(String.format("Category Not Found - Id: [%s] ", id)));
    }

    protected void removeUser(UserEntity entity) {
        userRepository.delete(entity);
    }

    protected SubCategoryEntity saveSubCategory(SubCategoryEntity entity){
        return subCategoryRepository.save(entity);
    }

    protected SubCategoryEntity searchSubCategoryRepository(Long id){
        return subCategoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(String.format("Category Not Found - Id: [%s] ", id)));
    }

    protected List<SubCategoryEntity> searchAllSubCategory(){
        return subCategoryRepository.findAll();
    }

    protected void removeSubCategory(SubCategoryEntity entity) {
        subCategoryRepository.delete(entity);
    }

    protected YearEntity saveYear(YearEntity entity) {
        return yearRepository.save(entity);
    }

    protected YearEntity searchYearById(Long id) {
        return yearRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(String.format("Category Not Found - Id: [%s] ", id)));
    }

    protected List<YearEntity> searchAllYear() {
        return yearRepository.findAll();
    }

    protected void removeYear(YearEntity entity) {
        yearRepository.delete(entity);
    }

    protected MonthsEntity searchMonthsById(Long id) {
        return monthsRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(String.format("Category Not Found - Id: [%s] ", id)));
    }

    protected List<MonthsEntity> searchAllMonths() {
        return monthsRepository.findAll();
    }
}
