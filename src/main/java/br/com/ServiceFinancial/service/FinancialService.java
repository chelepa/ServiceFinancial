package br.com.ServiceFinancial.service;

import br.com.ServiceFinancial.dto.account_bank.AccountBankDTO;
import br.com.ServiceFinancial.dto.account_bank.AccountBankRequestDTO;
import br.com.ServiceFinancial.dto.account_bank.AccountBankResponseDTO;
import br.com.ServiceFinancial.dto.account_bank.AccountBankUpdateDTO;
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
    List<AccountBankDTO> getAccountBankByUserId(Long userId);
    AccountBankDTO getAccountBankByUserIdAndId(Long userId, Long id);
    AccountBankDTO updateAccountBankByUserIdAndId(Long userId, Long id, AccountBankUpdateDTO request);
    void deleteAccountBankByUserIdAndId(Long userId, Long id);
}
