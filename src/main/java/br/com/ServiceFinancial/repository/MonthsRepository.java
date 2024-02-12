package br.com.ServiceFinancial.repository;

import br.com.ServiceFinancial.entity.MonthsUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MonthsRepository extends JpaRepository<MonthsUserEntity, Long> {

    Optional<MonthsUserEntity> findByNameAndYear_yearAndYear_user_id(String name, Long year, Long userId);
}
