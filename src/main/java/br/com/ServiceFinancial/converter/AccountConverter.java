package br.com.ServiceFinancial.converter;

import br.com.ServiceFinancial.dto.account.AccountFilterResponseDTO;
import br.com.ServiceFinancial.dto.account.AccountResponseDTO;
import br.com.ServiceFinancial.dto.filter.AccountFilterDTO;
import br.com.ServiceFinancial.entity.AccountEntity;
import br.com.ServiceFinancial.specification.SpecificationAccountByFilter;
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
}
