package br.com.ServiceFinancial.service.account;

import br.com.ServiceFinancial.converter.AccountConverter;
import br.com.ServiceFinancial.dto.account.AccountFilterResponseDTO;
import br.com.ServiceFinancial.dto.account.AccountRequestDTO;
import br.com.ServiceFinancial.dto.account.AccountResponseDTO;
import br.com.ServiceFinancial.dto.filter.AccountFilterDTO;
import br.com.ServiceFinancial.entity.AccountEntity;
import br.com.ServiceFinancial.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
@Service
public class AccountService extends BaseService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AccountConverter accountConverter;

    public AccountResponseDTO createAccount(AccountRequestDTO request) {
        log.info("AccountService.createAccount - Start - AccountRequestDTO: [{}]", request);
        var entityRequest = modelMapper.map(request, AccountEntity.class);
        var created = this.createAccountDB(entityRequest);
        var response = modelMapper.map(created, AccountResponseDTO.class);
        log.info("AccountService.createAccount - End - AccountRequestDTO: [{}], AccountResponseDTO: [{}]", request, response);
        return response;
    }

    public List<AccountResponseDTO> createAllAccount(List<AccountRequestDTO> request) {
        return request.stream().map(this::createAccount).toList();
    }

    public AccountFilterResponseDTO getAccount(Integer page, Integer size, String sort, String name, String userId, String monthId, String year, String categoryId, String subCategoryId) {
        var filter = AccountFilterDTO.builder().page(page).size(size).sort(sort).name(name).userId(userId).monthId(monthId).year(year).categoryId(categoryId).subCategoryId(subCategoryId).build();
        log.info("AccountService.getAccount - Start - ");
        var listAccount = this.getAccountDB(accountConverter.getByCriteria(filter), accountConverter.getPageRequest(filter));
        var response = accountConverter.map(listAccount);
        log.info("AccountService.getAccount - End - Response: [{}] ", response);
        return response;
    }

    public AccountResponseDTO paymentAccount(Long userId, Long accountId) {
        log.info("AccountService.paymentAccount - Start - UserId: [{}], AccountId: [{}]", userId, accountId);
        var accountEntity = this.searchAccountByUserIdAndAccountId(userId, accountId);
            accountEntity.setAccountPay(true);
            accountEntity.setDatePayment(ZonedDateTime.now());
        var created = this.createAccountDB(accountEntity);
        var response = modelMapper.map(created, AccountResponseDTO.class);
        log.info("AccountService.paymentAccount - Start - UserId: [{}], AccountId: [{}], Response: [{}]", userId, accountId, response);
        return response;
    }

    public AccountResponseDTO getAccountByUserIdAndAccountId(Long userId, Long accountId) {
        log.info("AccountService.getAccountByUserIdAndAccountId - Start - UserId: [{}], AccountId: [{}]", userId, accountId);
        var accountEntity = this.searchAccountByUserIdAndAccountId(userId, accountId);
        var response = modelMapper.map(accountEntity, AccountResponseDTO.class);
        log.info("AccountService.getAccountByUserIdAndAccountId - Start - UserId: [{}], AccountId: [{}], Response: [{}]", userId, accountId, response);
        return response;
    }

    public AccountResponseDTO updateAccount(Long userId, Long accountId, AccountRequestDTO request) {
        log.info("AccountService.updateAccount - Start - UserId: [{}], AccountId: [{}], AccountRequestDTO: [{}]", userId, accountId, request);
        var accountEntity = this.searchAccountByUserIdAndAccountId(userId, accountId);
        var update = accountConverter.updateAccount(accountEntity, request);
        var created = this.createAccountDB(update);
        var response = modelMapper.map(created, AccountResponseDTO.class);
        log.info("AccountService.updateAccount - End - UserId: [{}], AccountId: [{}], AccountRequestDTO: [{}], Response: [{}]", userId, accountId, request, response);
        return response;
    }

    public void deleteAccount(Long userId, Long accountId) {
        log.info("AccountService.deleteAccount - Start - UserId: [{}], AccountId: [{}]", userId, accountId);
        var accountEntity = this.searchAccountByUserIdAndAccountId(userId, accountId);
        this.deleteAccountDB(accountEntity);
        log.info("AccountService.deleteAccount - End - UserId: [{}], AccountId: [{}], Status: [DELETED]", userId, accountId);
    }
}
