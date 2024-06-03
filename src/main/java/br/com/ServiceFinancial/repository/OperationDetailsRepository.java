package br.com.ServiceFinancial.repository;

import br.com.ServiceFinancial.entity.OperationDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OperationDetailsRepository extends JpaRepository<OperationDetailsEntity, Long> {

    List<OperationDetailsEntity> findByAccountBank_accountBankIdAndAccountBank_user_userId(Long id, Long userId);

    List<OperationDetailsEntity> findByAccountBank_accountBankIdAndAccountBank_user_userIdAndOperationType_operationTypeId(Long accountBankId, Long userId, Long operationTypeId);

    Optional<OperationDetailsEntity> findByAccountBank_accountBankIdAndAccountBank_user_userIdAndOperationDetailId(Long accountBankId, Long userId, Long operationDetailId);
}
