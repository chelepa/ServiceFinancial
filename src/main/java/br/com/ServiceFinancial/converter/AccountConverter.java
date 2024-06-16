package br.com.ServiceFinancial.converter;

import br.com.ServiceFinancial.dto.account.AccountFilterResponseDTO;
import br.com.ServiceFinancial.dto.account.AccountRequestDTO;
import br.com.ServiceFinancial.dto.account.AccountResponseDTO;
import br.com.ServiceFinancial.dto.filter.AccountFilterDTO;
import br.com.ServiceFinancial.entity.*;
import br.com.ServiceFinancial.specification.SpecificationAccountByFilter;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountConverter {

    @Autowired
    private ModelMapper modelMapper;

    public AccountFilterResponseDTO map(Page<AccountEntity> listAccount) {
        var accounts = listAccount.getContent().stream().map(item -> modelMapper.map(item, AccountResponseDTO.class)).toList();
        var value = accounts.stream().map(AccountResponseDTO::getAccountValue).reduce(BigDecimal.ZERO, BigDecimal::add);

        return AccountFilterResponseDTO.builder()
                    .page(listAccount.getNumber())
                    .size(listAccount.getSize())
                    .totalPages(listAccount.getTotalPages())
                    .totalItem((int) listAccount.getTotalElements())
                    .value(value)
                    .accounts(accounts)
                .build();
    }

    public Specification<AccountEntity> getByCriteria(AccountFilterDTO filter) {
        return SpecificationAccountByFilter.findByCriteria(filter);
    }

    public PageRequest getPageRequest(AccountFilterDTO filter) {
        return PageRequest.of(filter.getPage(), filter.getSize(), getValidSort(filter.getSort()), "accountId");
    }

    public static Sort.Direction getValidSort(String sort) {
        return sort.equalsIgnoreCase(Sort.Direction.ASC.toString()) ? Sort.Direction.ASC : Sort.Direction.DESC;
    }

    public AccountEntity updateAccount(AccountEntity accountEntity, AccountRequestDTO request) {
        var response = new AccountEntity();
            response.setAccountId(accountEntity.getAccountId());
            response.setAccountPay(accountEntity.isAccountPay());
            response.setDatePayment(accountEntity.getDatePayment());
            response.setUser(accountEntity.getUser());
            response.setAccountDescription(StringUtils.isNotBlank(request.getAccountDescription()) ? request.getAccountDescription() : accountEntity.getAccountDescription());
            response.setAccountValue(request.getAccountValue() != null ? request.getAccountValue() : accountEntity.getAccountValue());
            response.setCategory(request.getCategoryId() != null ? updateCategory(request.getCategoryId()) : accountEntity.getCategory());
            response.setSubCategory(request.getSubCategoryId() != null ? updateSubCategory(request.getSubCategoryId()) : accountEntity.getSubCategory());
            response.setMonths(request.getMonthsId() != null ? updateMonths(request.getMonthsId()) : accountEntity.getMonths());
            response.setYear(request.getYear() != null ? updateYear(request.getYear()) : accountEntity.getYear());
        return response;
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
