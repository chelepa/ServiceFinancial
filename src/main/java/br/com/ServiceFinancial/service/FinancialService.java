package br.com.ServiceFinancial.service;

import br.com.ServiceFinancial.dto.account_bank.AccountBankRequestDTO;
import br.com.ServiceFinancial.dto.account_bank.AccountBankResponseDTO;
import br.com.ServiceFinancial.dto.operation_details.OperationDetailsRequestDTO;
import br.com.ServiceFinancial.dto.operation_details.OperationDetailsResponseDTO;
import br.com.ServiceFinancial.dto.operation_type.OperationTypeResponseDTO;
import br.com.ServiceFinancial.dto.user.UserRequestDTO;
import br.com.ServiceFinancial.dto.user.UserResponseDTO;

import java.util.List;

public interface FinancialService {

    UserResponseDTO getUserById(Long userId);
    UserResponseDTO createUser(UserRequestDTO request);
    void deleteUserById(Long userId);

    OperationTypeResponseDTO getOperationTypeById(Long id);
    List<OperationTypeResponseDTO> getAllOperationType();

    AccountBankResponseDTO createAccountBank(AccountBankRequestDTO request);
    List<AccountBankResponseDTO> getAccountBankByUserId(Long userId);
    AccountBankResponseDTO getAccountBankByUserIdAndId(Long userId, Long id);
    AccountBankResponseDTO updateAccountBankByUserIdAndId(Long userId, Long id, AccountBankRequestDTO request);
    void deleteAccountBankByUserIdAndId(Long userId, Long id);

    OperationDetailsResponseDTO createOperationDetails(OperationDetailsRequestDTO request);
    List<OperationDetailsResponseDTO> getOperationDetailsByUserIdAndAccountId(Long userId, Long accountBankId);
    List<OperationDetailsResponseDTO> getOperationDetailsByUserIdAndAccountIdAndOperationTypeId(Long userId, Long accountBankId, Long operationTypeId);
    OperationDetailsResponseDTO updateOperationDetailsByUserIdAndAccountId(Long userId, Long accountBankId, Long operationDetailsId, OperationDetailsRequestDTO request);
    void deleteOperationDetailsByUserIdAndAccountId(Long userId, Long accountBankId, Long operationDetailsId);
}
