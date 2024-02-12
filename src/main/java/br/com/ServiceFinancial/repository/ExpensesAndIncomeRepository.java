package br.com.ServiceFinancial.repository;

import br.com.ServiceFinancial.entity.ExpensesAndIncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensesAndIncomeRepository extends JpaRepository<ExpensesAndIncomeEntity, Long> {
}
