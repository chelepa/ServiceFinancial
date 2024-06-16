package br.com.ServiceFinancial.repository;

import br.com.ServiceFinancial.entity.AccountEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long>{

    Page<AccountEntity> findAll(Specification<AccountEntity> criteria, Pageable page);
    AccountEntity findByUser_userIdAndAccountId(Long userId, Long accountId);
}