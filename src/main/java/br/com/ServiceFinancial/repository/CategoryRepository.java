package br.com.ServiceFinancial.repository;

import br.com.ServiceFinancial.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

    List<CategoryEntity> findByUser_userId(Long userId);
    CategoryEntity findByUser_userIdAndCategoryId(Long userId, Long categoryId);
}