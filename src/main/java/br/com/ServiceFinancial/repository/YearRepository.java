package br.com.ServiceFinancial.repository;

import br.com.ServiceFinancial.entity.YearUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface YearRepository extends JpaRepository<YearUserEntity, Long> {

    Optional<YearUserEntity> findByYearAndUser_id(Long year, Long userId);

}
