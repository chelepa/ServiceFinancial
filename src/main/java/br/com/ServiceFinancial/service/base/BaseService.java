package br.com.ServiceFinancial.service.base;

import br.com.ServiceFinancial.entity.AccountBankEntity;
import br.com.ServiceFinancial.entity.OperationTypeEntity;
import br.com.ServiceFinancial.entity.UserEntity;
import br.com.ServiceFinancial.repository.AccountBankRepository;
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
}
