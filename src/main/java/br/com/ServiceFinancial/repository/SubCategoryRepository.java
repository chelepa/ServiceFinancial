package br.com.ServiceFinancial.repository;

import br.com.ServiceFinancial.entity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity, Long> {
}
