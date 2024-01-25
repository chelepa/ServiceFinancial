package br.com.ServiceFinancial.service.category;

import br.com.ServiceFinancial.dto.category.CategoryRequestDTO;
import br.com.ServiceFinancial.dto.category.CategoryResponseDTO;
import br.com.ServiceFinancial.entity.CategoryEntity;
import br.com.ServiceFinancial.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Service
public class CategoryService extends BaseService {

    @Autowired
    private ModelMapper modelMapper;

    public CategoryResponseDTO createCategory(CategoryRequestDTO request) {
        log.info("CategoryService.createCategory - Start - CategoryRequestDTO: [{}]", request);
        var entity = modelMapper.map(request, CategoryEntity.class);
        var newEntity = this.saveCategory(entity);
        var response = modelMapper.map(newEntity, CategoryResponseDTO.class);
        log.info("CategoryService.createCategory - End - CategoryResponseDTO: [{}]", response);
        return response;
    }

    public CategoryResponseDTO getCategoryById(Long id) {
        log.info("CategoryService.getCategoryById - Start - Id: [{}]", id);
        var entity = this.searchCategoryById(id);
        var response = modelMapper.map(entity, CategoryResponseDTO.class);
        log.info("CategoryService.getCategoryById - End -  Id: [{}] CategoryResponseDTO: [{}]", id, response);
        return response;
    }

    public List<CategoryResponseDTO> getAllCategory() {
        log.info("CategoryService.getAllCategory - Start - ");
        var listCategory = this.searchAllCategory();
        var response = listCategory.stream().map(category -> modelMapper.map(category, CategoryResponseDTO.class)).toList();
        log.info("CategoryService.getAllCategory - End - Response: [{}]", response);
        return response;
    }

    public void deleteCategoryById(Long id) {
        log.info("CategoryService.deleteCategoryById - Start - Id: [{}]", id);
        var entity = this.searchCategoryById(id);
        this.removeCategoryById(entity);
        log.info("CategoryService.deleteCategoryById - End - id: [{}] - Deleted", id);
    }

    public CategoryResponseDTO updateCategoryById(Long id, CategoryRequestDTO request) {
        log.info("CategoryService.updateCategoryById - Start - Id: [{}] CategoryRequestDTO: [{}]", id, request);
        var entity = this.searchCategoryById(id);
        modelMapper.map(request, entity);
        var newEntity = this.saveCategory(entity);
        var response = modelMapper.map(newEntity, CategoryResponseDTO.class);
        log.info("CategoryService.updateCategoryById - End - Id: [{}] CategoryRequestDTO: [{}] CategoryResponseDTO: [{}]",  id, request, response);
        return response;
    }
}
