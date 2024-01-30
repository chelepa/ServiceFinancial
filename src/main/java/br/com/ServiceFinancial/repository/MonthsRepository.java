package br.com.ServiceFinancial.repository;

import br.com.ServiceFinancial.entity.MonthsUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthsRepository extends JpaRepository<MonthsUserEntity, Long> {
}
