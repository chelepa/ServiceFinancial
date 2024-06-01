package br.com.ServiceFinancial.repository;

import br.com.ServiceFinancial.entity.AccountBankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountBankRepository extends JpaRepository<AccountBankEntity, Long>{

    List<AccountBankEntity> findByUser_userId(Long userId);
    AccountBankEntity findByAccountBankIdAndUser_userId(Long accountBankId, Long userId);
}