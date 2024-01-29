package br.com.ServiceFinancial.repository;

import br.com.ServiceFinancial.entity.MonthsEntity;
import br.com.ServiceFinancial.entity.YearEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthsRepository extends JpaRepository<MonthsEntity, Long> {
}
