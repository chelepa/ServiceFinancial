package br.com.ServiceFinancial.repository;

import br.com.ServiceFinancial.entity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity, Long>{

    List<SubCategoryEntity> findByCategory_categoryIdAndCategory_User_userId(Long categoryId, Long userId);
    SubCategoryEntity findByCategory_categoryIdAndCategory_User_userIdAndSubCategoryId(Long categoryId, Long userId, Long SubCategoryId);
}