package br.com.ServiceFinancial.service.operation;

import br.com.ServiceFinancial.dto.account_bank.AccountBankRequestDTO;
import br.com.ServiceFinancial.dto.account_bank.AccountBankResponseDTO;
import br.com.ServiceFinancial.entity.AccountBankEntity;
import br.com.ServiceFinancial.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AccountBankService extends BaseService {

    @Autowired
    private ModelMapper modelMapper;

    public AccountBankResponseDTO createAccountBank(AccountBankRequestDTO request) {
        log.info("AccountBankService.CreateAccountBank - Start - AccountBankRequestDTO: [{}] ", request);
        var entityRequest = modelMapper.map(request, AccountBankEntity.class);
        var entity = this.createAccountBankDB(entityRequest);
        var response = modelMapper.map(entity, AccountBankResponseDTO.class);
        log.info("AccountBankService.CreateAccountBank - End - AccountBankRequestDTO: [{}], AccountBankResponseDTO: [{}] ", request, response);
        return response;
    }

    public List<AccountBankResponseDTO> getAccountBankByUserId(Long userId) {
        log.info("AccountBankService.getAccountBankByUserId - Start - UserId: [{}] ", userId);
        var entity = this.getAllAccountBankByUserId(userId);
        var responseList = entity.stream().map(item -> modelMapper.map(item, AccountBankResponseDTO.class)).toList();
        log.info("AccountBankService.getAccountBankByUserId - End - UserId: [{}], ListResponse: [{}] ", userId, responseList);
        return responseList;
    }

    public AccountBankResponseDTO getAccountBankByUserIdAndId(Long userId, Long id) {
        log.info("AccountBankService.getAccountBankByUserIdAndId - Start - UserId: [{}], Id: [{}] ", userId, id);
        var entity = this.getAllAccountBankByUserIdAndId(id, userId);
        var response = modelMapper.map(entity, AccountBankResponseDTO.class);
        log.info("AccountBankService.getAccountBankByUserIdAndId - End - UserId: [{}], Id: [{}], Response: [{}] ", userId, id, response);
        return response;
    }

    public AccountBankResponseDTO updateAccountBankByUserIdAndId(Long userId, Long id, AccountBankRequestDTO request) {
        log.info("AccountBankService.updateAccountBankByUserIdAndId - Start - UserId: [{}], Id: [{}], AccountBankUpdateDTO: [{}] ", userId, id, request);
        var entity = this.getAllAccountBankByUserIdAndId(id, userId);
            entity.setAccountBankDescription(request.getAccountBankDescription());
        this.createAccountBankDB(entity);
        var response = modelMapper.map(entity, AccountBankResponseDTO.class);
        log.info("AccountBankService.updateAccountBankByUserIdAndId - End - UserId: [{}], Id: [{}], AccountBankUpdateDTO: [{}], Response: [{}] ", userId, id, request, response);
        return response;
    }

    public void deleteAccountBankByUserIdAndId(Long userId, Long id) {
        log.info("AccountBankService.deleteAccountBankByUserIdAndId - Start - UserId: [{}], Id: [{}] ", userId, id);
        var entity = this.getAllAccountBankByUserIdAndId(id, userId);
        this.deleteAccountBank(entity);
        log.info("AccountBankService.deleteAccountBankByUserIdAndId - End - UserId: [{}], Id: [{}], [DELETED] ", userId, id);
    }
}
