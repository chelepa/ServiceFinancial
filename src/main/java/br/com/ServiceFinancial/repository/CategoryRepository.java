package br.com.ServiceFinancial.repository;

import br.com.ServiceFinancial.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

    List<CategoryEntity> findByUser_userId(Long userId);
    Optional<CategoryEntity> findByUser_userIdAndCategoryId(Long userId, Long categoryId);
}