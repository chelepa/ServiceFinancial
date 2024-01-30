package br.com.ServiceFinancial.repository;

import br.com.ServiceFinancial.entity.YearUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YearRepository extends JpaRepository<YearUserEntity, Long> {
}
