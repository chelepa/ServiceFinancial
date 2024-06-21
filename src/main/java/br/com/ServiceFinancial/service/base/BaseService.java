package br.com.ServiceFinancial.service.base;

import br.com.ServiceFinancial.entity.*;
import br.com.ServiceFinancial.exceptions.*;
import br.com.ServiceFinancial.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OperationTypeRepository operationTypeRepository;
    @Autowired
    private AccountBankRepository accountBankRepository;
    @Autowired
    private OperationDetailsRepository operationDetailsRepository;
    @Autowired
    private YearEntityRepository yearEntityRepository;
    @Autowired
    private MonthsEntityRepository monthsEntityRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private AccountRepository accountRepository;

    protected UserEntity createUserDb(UserEntity usersEntity){
        return userRepository.save(usersEntity);
    }

    protected UserEntity searchUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserException(String.format("User Not Found - userId: [%s] ", userId)));
    }

    protected void removeUserEntity(UserEntity userEntity) {
        userRepository.delete(userEntity);
    }

    protected OperationTypeEntity searchOperationTypeById(Long id) {
        return operationTypeRepository.findById(id).orElseThrow(() -> new OperationTypeException(String.format("Operation Type Not Found - Id: [%s] ", id)));
    }

    protected List<OperationTypeEntity> searchAllOperationType() {
        return operationTypeRepository.findAll();
    }

    protected AccountBankEntity createAccountBankDB(AccountBankEntity request) {
        return accountBankRepository.save(request);
    }

    protected List<AccountBankEntity> getAllAccountBankByUserId(Long userId) {
        return accountBankRepository.findByUser_userId(userId);
    }

    protected AccountBankEntity getAllAccountBankByUserIdAndId(Long accountBankId, Long userId) {
        return accountBankRepository.findByAccountBankIdAndUser_userId(accountBankId, userId).orElseThrow(() -> new AccountBankException(String.format("Account Bank Not Found - AccountBankId: [%s], UserId: [%s] ", accountBankId, userId)));
    }

    protected void deleteAccountBank(AccountBankEntity entity) {
        accountBankRepository.delete(entity);
    }

    protected OperationDetailsEntity createOperationDetailsDB(OperationDetailsEntity entityRequest) {
        return operationDetailsRepository.save(entityRequest);
    }

    protected List<OperationDetailsEntity> searchOperationDetailsByUserIdAndAccountId(Long accountBankId, Long userId) {
        return operationDetailsRepository.findByAccountBank_accountBankIdAndAccountBank_user_userId(accountBankId, userId);
    }

    protected List<OperationDetailsEntity> searchOperationDetailsByUserIdAndAccountIdAndOperationTypeId(Long accountBankId, Long userId, Long operationTypeId) {
        return operationDetailsRepository.findByAccountBank_accountBankIdAndAccountBank_user_userIdAndOperationType_operationTypeId(accountBankId, userId, operationTypeId);
    }

    protected OperationDetailsEntity searchOperationDetailsByUserIdAndAccountIdAndOperationDetailId(Long accountBankId, Long userId, Long operationDetailId) {
        return operationDetailsRepository.findByAccountBank_accountBankIdAndAccountBank_user_userIdAndOperationDetailId(accountBankId, userId, operationDetailId).orElseThrow(() -> new OperationDetailsException(String.format("Operation Details Not Found - AccountBankId: [%s], UserId: [%s], OperationDetailId: [%s] ", accountBankId, userId, operationDetailId)));
    }

    protected void deleteOperationDetailsByUserIdAndAccountIdDB(OperationDetailsEntity entityRequest) {
        operationDetailsRepository.delete(entityRequest);
    }

    protected YearEntity saveNewYear(YearEntity request) {
        return yearEntityRepository.save(request);
    }

    protected List<MonthsEntity> searchAllMonths() {
        return monthsEntityRepository.findAll();
    }

    protected CategoryEntity createCategoryDB(CategoryEntity entityRequest) {
        return categoryRepository.save(entityRequest);
    }

    protected List<CategoryEntity> searchAllCategoryByUserId(Long userId) {
        return categoryRepository.findByUser_userId(userId);
    }

    protected CategoryEntity searchCategoryByUserIdAndCategoryId(Long userId, Long categoryId) {
        return categoryRepository.findByUser_userIdAndCategoryId(userId, categoryId).orElseThrow(() -> new CategoryException(String.format("Category Not Found - UserId: [%s], categoryId: [%s] ", userId, categoryId)));
    }

    protected void deleteCategory(CategoryEntity entity) {
        categoryRepository.delete(entity);
    }

    protected SubCategoryEntity createSubCategoryDB(SubCategoryEntity entity) {
        return subCategoryRepository.save(entity);
    }

    protected List<SubCategoryEntity> getAllSubCategoryByUserIdAndCategoryId(Long userId, Long categoryId) {
        return subCategoryRepository.findByCategory_categoryIdAndCategory_User_userId(categoryId, userId);
    }

    protected SubCategoryEntity getAllSubCategoryByUserIdAndCategoryIdAndSubCategoryId(Long userId, Long categoryId, Long subCategoryId) {
        return subCategoryRepository.findByCategory_categoryIdAndCategory_User_userIdAndSubCategoryId(categoryId, userId, subCategoryId).orElseThrow(() -> new SubCategoryException(String.format("SubCategory Not Found - UserId: [%s], categoryId: [%s], subCategoryId: [%s]", userId, categoryId, subCategoryId)));
    }

    protected void deleteSubCategory(SubCategoryEntity responseEntity) {
        subCategoryRepository.delete(responseEntity);
    }

    protected AccountEntity createAccountDB(AccountEntity entityRequest) {
        return accountRepository.save(entityRequest);
    }

    protected Page<AccountEntity> getAccountDB(Specification<AccountEntity> byCriteria, PageRequest pageRequest) {
        return accountRepository.findAll(byCriteria, pageRequest);
    }

    protected AccountEntity searchAccountByUserIdAndAccountId(Long userId, Long accountId) {
        return accountRepository.findByUser_userIdAndAccountId(userId, accountId).orElseThrow(() -> new AccountException(String.format("Account Not Found - UserId: [%s], accountId: [%s]", userId, accountId)));
    }

    protected void deleteAccountDB(AccountEntity accountEntity) {
        accountRepository.delete(accountEntity);
    }
}
