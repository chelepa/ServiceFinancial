package br.com.ServiceFinancial.converter;

import br.com.ServiceFinancial.dto.account.AccountRequestDTO;
import br.com.ServiceFinancial.entity.*;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.util.Objects;

public class AccountRequestDTOToAccountEntityConverter implements Converter<AccountRequestDTO, AccountEntity> {

    @Override
    public AccountEntity convert(MappingContext<AccountRequestDTO, AccountEntity> context) {
        var v1 = context.getDestination();
        var v2 = context.getSource();

        var destination = Objects.isNull(v1) ? new AccountEntity() : context.getDestination();
        destination.setAccountId(v1.getAccountId() == null ? null : v1.getAccountId());
        destination.setAccountPay(v1.isAccountPay());
        destination.setDatePayment(v1.getDatePayment());
        destination.setUser(v1.getUser());
        destination.setAccountDescription(StringUtils.isNotBlank(v2.getAccountDescription()) ? v2.getAccountDescription() : v1.getAccountDescription());
        destination.setAccountValue(v2.getAccountValue() != null ? v2.getAccountValue() : v1.getAccountValue());
        destination.setCategory(v2.getCategoryId() != null ? updateCategory(v2.getCategoryId()) : v1.getCategory());
        destination.setSubCategory(v2.getSubCategoryId() != null ? updateSubCategory(v2.getSubCategoryId()) : v1.getSubCategory());
        destination.setMonths(v2.getMonthsId() != null ? updateMonths(v2.getMonthsId()) : v1.getMonths());
        destination.setYear(v2.getYear() != null ? updateYear(v2.getYear()) : v1.getYear());
        return destination;
    }

    private YearEntity updateYear(Long year) {
        var response = new YearEntity();
        response.setYear(year);
        return response;
    }

    private MonthsEntity updateMonths(Long monthsId) {
        var response = new MonthsEntity();
        response.setMonthsId(monthsId);
        return response;
    }

    private SubCategoryEntity updateSubCategory(Long id) {
        var response = new SubCategoryEntity();
        response.setSubCategoryId(id);
        return response;
    }

    private CategoryEntity updateCategory(Long categoryId) {
        var response = new CategoryEntity();
        response.setCategoryId(categoryId);
        return response;
    }
}
