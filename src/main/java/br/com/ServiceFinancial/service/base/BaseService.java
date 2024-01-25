package br.com.ServiceFinancial.service.base;

import br.com.ServiceFinancial.entity.CategoryEntity;
import br.com.ServiceFinancial.exceptions.CategoryNotFoundException;
import br.com.ServiceFinancial.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService {

    @Autowired
    private CategoryRepository categoryRepository;

    protected CategoryEntity saveCategory(CategoryEntity entity){
        return categoryRepository.save(entity);
    }

    protected CategoryEntity searchCategoryById(Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(String.format("Category Not Found - Id: [%s] ", id)));
    }

    protected List<CategoryEntity> searchAllCategory(){
        return categoryRepository.findAll();
    }

    protected void removeCategoryById(CategoryEntity entity) {
        categoryRepository.delete(entity);
    }
}
