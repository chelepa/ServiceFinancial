package br.com.ServiceFinancial.service.base;

import br.com.ServiceFinancial.entity.AccountBankEntity;
import br.com.ServiceFinancial.entity.OperationDetailsEntity;
import br.com.ServiceFinancial.entity.OperationTypeEntity;
import br.com.ServiceFinancial.entity.UserEntity;
import br.com.ServiceFinancial.repository.AccountBankRepository;
import br.com.ServiceFinancial.repository.OperationDetailsRepository;
import br.com.ServiceFinancial.repository.OperationTypeRepository;
import br.com.ServiceFinancial.repository.UserRepository;
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
}
