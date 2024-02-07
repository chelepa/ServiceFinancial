package br.com.ServiceFinancial.utils;

import br.com.ServiceFinancial.constants.Constants;
import br.com.ServiceFinancial.entity.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class UtilsBuilder {

    public List<CategoryEntity> createListCategoryDefault(UserEntity user) {
        var nameCategoryDefault = List.of("Receitas", "Despesas");
        List<CategoryEntity> response = new ArrayList<>();
        nameCategoryDefault.forEach(name -> response.add(populateCategoryDefault(name, user)));
        return response;
    }

    public List<SubCategoryEntity> createListSubCategoryDefault(CategoryEntity category) {
        var nameCategoryDefault = List.of("Sem Categoria");
        List<SubCategoryEntity> response = new ArrayList<>();
        nameCategoryDefault.forEach(name -> response.add(populateSubCategoryDefault(name, category)));
        return response;
    }

    private SubCategoryEntity populateSubCategoryDefault(String name, CategoryEntity category) {
        var response = new SubCategoryEntity();
        response.setName(name);
        response.setCategory(category);
        return response;
    }

    private CategoryEntity populateCategoryDefault(String name, UserEntity user) {
        var response = new CategoryEntity();
        response.setName(name);
        response.setUser(user);
        return response;
    }

    public List<YearUserEntity> createListYearsDefault(UserEntity user) {
        List<YearUserEntity> response = new ArrayList<>();
        Constants.LIST_YEARS.forEach(year -> response.add(populateYear(year, user)));
        return response;
    }

    private YearUserEntity populateYear(Long year, UserEntity user) {
        YearUserEntity response = new YearUserEntity();
        response.setYear(year);
        response.setUser(user);
        return response;
    }

    public List<MonthsUserEntity> createListMonths(YearUserEntity year) {
        List<MonthsUserEntity> response = new ArrayList<>();
        Constants.LIST_MONTHS.forEach(Months -> response.add(createMonths(Months, year)));
        return response;
    }

    private MonthsUserEntity createMonths(String months, YearUserEntity year) {
        MonthsUserEntity response = new MonthsUserEntity();
        response.setName(months);
        response.setYear(year);
        response.setValueRevenues(BigDecimal.valueOf(0));
        response.setValueExpenses(BigDecimal.valueOf(0));
        return response;
    }
}
