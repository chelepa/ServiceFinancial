package br.com.ServiceFinancial.repository;


import br.com.ServiceFinancial.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
