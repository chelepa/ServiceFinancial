package br.com.ServiceFinancial.repository;

import br.com.ServiceFinancial.entity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity, Long>{

    List<SubCategoryEntity> findByCategory_categoryIdAndCategory_User_userId(Long categoryId, Long userId);
    Optional<SubCategoryEntity> findByCategory_categoryIdAndCategory_User_userIdAndSubCategoryId(Long categoryId, Long userId, Long SubCategoryId);
}