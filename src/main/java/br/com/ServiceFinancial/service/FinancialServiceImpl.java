package br.com.ServiceFinancial.service;

import br.com.ServiceFinancial.dto.account_bank.AccountBankDTO;
import br.com.ServiceFinancial.dto.account_bank.AccountBankRequestDTO;
import br.com.ServiceFinancial.dto.account_bank.AccountBankResponseDTO;
import br.com.ServiceFinancial.dto.account_bank.AccountBankUpdateDTO;
import br.com.ServiceFinancial.dto.operation_type.OperationTypeResponseDTO;
import br.com.ServiceFinancial.dto.user.UserRequestDTO;
import br.com.ServiceFinancial.dto.user.UserResponseDTO;
import br.com.ServiceFinancial.service.operation.AccountBankService;
import br.com.ServiceFinancial.service.operation.OperationTypeService;
import br.com.ServiceFinancial.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FinancialServiceImpl implements FinancialService {

    private final UserService userService;
    private final OperationTypeService operationTypeService;
    private final AccountBankService accountBankService;

    @Override
    public UserResponseDTO getUserById(Long userId) {
        return userService.getUserById(userId);
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO request) {
        return userService.createUser(request);
    }

    @Override
    public void deleteUserById(Long userId) {
        userService.deleteUserById(userId);
    }

    @Override
    public OperationTypeResponseDTO getOperationTypeById(Long id) {
        return operationTypeService.getOperationTypeById(id);
    }

    @Override
    public List<OperationTypeResponseDTO> getAllOperationType() {
        return operationTypeService.getAllOperationType();
    }

    @Override
    public AccountBankResponseDTO createAccountBank(AccountBankRequestDTO request) {
        return accountBankService.createAccountBank(request);
    }

    @Override
    public List<AccountBankDTO> getAccountBankByUserId(Long userId) {
        return accountBankService.getAccountBankByUserId(userId);
    }

    @Override
    public AccountBankDTO getAccountBankByUserIdAndId(Long userId, Long id) {
        return accountBankService.getAccountBankByUserIdAndId(userId, id);
    }

    @Override
    public AccountBankDTO updateAccountBankByUserIdAndId(Long userId, Long id, AccountBankUpdateDTO request) {
        return accountBankService.updateAccountBankByUserIdAndId(userId, id, request);
    }

    @Override
    public void deleteAccountBankByUserIdAndId(Long userId, Long id) {
        accountBankService.deleteAccountBankByUserIdAndId(userId, id);
    }
}
