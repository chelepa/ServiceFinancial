package br.com.ServiceFinancial.service;

import br.com.ServiceFinancial.dto.account.AccountFilterResponseDTO;
import br.com.ServiceFinancial.dto.account.AccountRequestDTO;
import br.com.ServiceFinancial.dto.account.AccountResponseDTO;
import br.com.ServiceFinancial.dto.account_bank.AccountBankRequestDTO;
import br.com.ServiceFinancial.dto.account_bank.AccountBankResponseDTO;
import br.com.ServiceFinancial.dto.category.CategoryRequestDTO;
import br.com.ServiceFinancial.dto.category.CategoryResponseDTO;
import br.com.ServiceFinancial.dto.operation_details.OperationDetailsRequestDTO;
import br.com.ServiceFinancial.dto.operation_details.OperationDetailsResponseDTO;
import br.com.ServiceFinancial.dto.operation_type.OperationTypeResponseDTO;
import br.com.ServiceFinancial.dto.sub_category.SubCategoryRequestDTO;
import br.com.ServiceFinancial.dto.sub_category.SubCategoryResponseDTO;
import br.com.ServiceFinancial.dto.user.UserRequestDTO;
import br.com.ServiceFinancial.dto.user.UserResponseDTO;
import br.com.ServiceFinancial.dto.year.YearRequestDTO;
import br.com.ServiceFinancial.dto.year.YearResponseDTO;

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

    YearResponseDTO createYear(YearRequestDTO request);

    CategoryResponseDTO createCategory(CategoryRequestDTO request);
    CategoryResponseDTO getAllCategoryByUserIdAndCategoryId(Long userId, Long categoryId);
    CategoryResponseDTO updateCategoryByUserId(Long userId, Long categoryId, CategoryRequestDTO request);
    List<CategoryResponseDTO> getAllCategoryByUserId(Long userId);
    void deleteCategoryByUserId(Long userId, Long categoryId);

    SubCategoryResponseDTO createSubCategory(SubCategoryRequestDTO request);
    List<SubCategoryResponseDTO> getAllSubCategoryByUserId(Long userId, Long categoryId);
    SubCategoryResponseDTO updateSubCategoryByUserId(Long userId, Long categoryId, Long subCategoryId, SubCategoryRequestDTO request);
    SubCategoryResponseDTO GetSubCategoryByUserIdAndCategoryIdAndSubCategoryId(Long userId, Long categoryId, Long subCategoryId);
    void deleteSubCategoryByUserId(Long userId, Long categoryId, Long subCategoryId);

    AccountResponseDTO createAccount(AccountRequestDTO request);
    List<AccountResponseDTO> createAllAccount(List<AccountRequestDTO> request);
    AccountResponseDTO paymentAccount(Long userId, Long accountId);
    AccountResponseDTO getAccountByUserIdAndAccountId(Long userId, Long accountId);
    AccountFilterResponseDTO getAccount(Integer page, Integer size, String sort, String name, String userId, String monthId, String year, String categoryId, String subCategoryId);
    AccountResponseDTO updateAccount(Long userId, Long accountId, AccountRequestDTO request);
    void deleteAccount(Long userId, Long accountId);
}
