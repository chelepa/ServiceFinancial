package br.com.ServiceFinancial.service.base;

import br.com.ServiceFinancial.entity.*;
import br.com.ServiceFinancial.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    protected UserEntity createUserDb(UserEntity usersEntity){
        return userRepository.save(usersEntity);
    }

    protected UserEntity searchUserById(Long userId) {
        return userRepository.findById(userId).orElseGet(null);
    }

    protected void removeUserEntity(UserEntity userEntity) {
        userRepository.delete(userEntity);
    }

    protected OperationTypeEntity searchOperationTypeById(Long id) {
        return operationTypeRepository.findById(id).orElseGet(null);
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
        return accountBankRepository.findByAccountBankIdAndUser_userId(accountBankId, userId);
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
        return operationDetailsRepository.findByAccountBank_accountBankIdAndAccountBank_user_userIdAndOperationDetailId(accountBankId, userId, operationDetailId).orElseGet(null);
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
        return categoryRepository.findByUser_userIdAndCategoryId(userId, categoryId);
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
        return subCategoryRepository.findByCategory_categoryIdAndCategory_User_userIdAndSubCategoryId(categoryId, userId, subCategoryId);
    }

    protected void deleteSubCategory(SubCategoryEntity responseEntity) {
        subCategoryRepository.delete(responseEntity);
    }
}
