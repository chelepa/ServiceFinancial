package br.com.ServiceFinancial.service;

import br.com.ServiceFinancial.dto.account_bank.AccountBankRequestDTO;
import br.com.ServiceFinancial.dto.account_bank.AccountBankResponseDTO;
import br.com.ServiceFinancial.dto.operation_details.OperationDetailsRequestDTO;
import br.com.ServiceFinancial.dto.operation_details.OperationDetailsResponseDTO;
import br.com.ServiceFinancial.dto.operation_type.OperationTypeResponseDTO;
import br.com.ServiceFinancial.dto.user.UserRequestDTO;
import br.com.ServiceFinancial.dto.user.UserResponseDTO;
import br.com.ServiceFinancial.service.operation.AccountBankService;
import br.com.ServiceFinancial.service.operation.OperationDetailsService;
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
    private final OperationDetailsService operationDetailsService;

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
    public List<AccountBankResponseDTO> getAccountBankByUserId(Long userId) {
        return accountBankService.getAccountBankByUserId(userId);
    }

    @Override
    public AccountBankResponseDTO getAccountBankByUserIdAndId(Long userId, Long id) {
        return accountBankService.getAccountBankByUserIdAndId(userId, id);
    }

    @Override
    public AccountBankResponseDTO updateAccountBankByUserIdAndId(Long userId, Long id, AccountBankRequestDTO request) {
        return accountBankService.updateAccountBankByUserIdAndId(userId, id, request);
    }

    @Override
    public void deleteAccountBankByUserIdAndId(Long userId, Long id) {
        accountBankService.deleteAccountBankByUserIdAndId(userId, id);
    }

    @Override
    public OperationDetailsResponseDTO createOperationDetails(OperationDetailsRequestDTO request) {
        return operationDetailsService.createOperationDetails(request);
    }

    @Override
    public List<OperationDetailsResponseDTO> getOperationDetailsByUserIdAndAccountId(Long userId, Long accountBankId) {
        return operationDetailsService.getOperationDetailsByUserIdAndAccountId(userId, accountBankId);
    }

    @Override
    public List<OperationDetailsResponseDTO> getOperationDetailsByUserIdAndAccountIdAndOperationTypeId(Long userId, Long accountBankId, Long operationTypeId) {
        return operationDetailsService.getOperationDetailsByUserIdAndAccountIdAndOperationTypeId(userId, accountBankId, operationTypeId);
    }

    @Override
    public OperationDetailsResponseDTO updateOperationDetailsByUserIdAndAccountId(Long userId, Long accountBankId, Long operationDetailsId, OperationDetailsRequestDTO request) {
        return operationDetailsService.updateOperationDetailsByUserIdAndAccountId(userId, accountBankId, operationDetailsId, request);
    }

    @Override
    public void deleteOperationDetailsByUserIdAndAccountId(Long userId, Long accountBankId, Long operationDetailsId) {
        operationDetailsService.deleteOperationDetailsByUserIdAndAccountId(userId, accountBankId, operationDetailsId);
    }
}
