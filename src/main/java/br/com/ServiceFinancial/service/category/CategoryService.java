package br.com.ServiceFinancial.service.category;

import br.com.ServiceFinancial.dto.category.CategoryRequestDTO;
import br.com.ServiceFinancial.dto.category.CategoryResponseDTO;
import br.com.ServiceFinancial.dto.operation_details.OperationDetailsResponseDTO;
import br.com.ServiceFinancial.entity.AccountBankEntity;
import br.com.ServiceFinancial.entity.CategoryEntity;
import br.com.ServiceFinancial.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryService extends BaseService {

    @Autowired
    private ModelMapper modelMapper;

    public CategoryResponseDTO createCategory(CategoryRequestDTO request) {
        log.info("CategoryService.createCategory - Start - CategoryRequestDTO: [{}]", request);
        var entityRequest = modelMapper.map(request, CategoryEntity.class);
            entityRequest.setCategoryId(null);
        var entity = this.createCategoryDB(entityRequest);
        var response = modelMapper.map(entity, CategoryResponseDTO.class);
        log.info("CategoryService.createCategory - End - CategoryRequestDTO: [{}], CategoryResponseDTO: [{}]", request, response);
        return response;
    }

    public List<CategoryResponseDTO> getAllCategoryByUserId(Long userId) {
        log.info("CategoryService.getAllCategoryByUserId - Start - UserId: [{}]", userId);
        var entity = this.searchAllCategoryByUserId(userId);
        var responseList = entity.stream().map(item -> modelMapper.map(item, CategoryResponseDTO.class)).toList();
        log.info("CategoryService.getAllCategoryByUserId - End - UserId: [{}], Response: [{}]", userId, responseList);
        return responseList;
    }

    public CategoryResponseDTO updateCategoryByUserId(Long userId, Long categoryId, CategoryRequestDTO request) {
        log.info("CategoryService.UpdateAllCategoryByUserIdy - Start - UserId: [{}], CategoryId: [{}], CategoryRequestDTO: [{}]", userId, categoryId, request);
        var entityResponse = this.searchCategoryByUserIdAndCategoryId(userId, categoryId);
            entityResponse.setCategoryName(request.getCategoryName());
        var entity = this.createCategoryDB(entityResponse);
        var response = modelMapper.map(entity, CategoryResponseDTO.class);
        log.info("CategoryService.UpdateAllCategoryByUserIdy - End - UserId: [{}], CategoryId: [{}], CategoryRequestDTO: [{}], Response: [{}]", userId, categoryId, request, response);
        return response;
    }

    public void deleteCategoryByUserId(Long userId, Long categoryId) {
        log.info("CategoryService.DeleteCategoryByUserId - Start - UserId: [{}], CategoryId: [{}]", userId, categoryId);
        var entityResponse = this.searchCategoryByUserIdAndCategoryId(userId, categoryId);
        this.deleteCategory(entityResponse);
        log.info("CategoryService.DeleteCategoryByUserId - End - UserId: [{}], CategoryId: [{}], Status: [DELETED]", userId, categoryId);
    }

    public CategoryResponseDTO getAllCategoryByUserIdAndCategoryId(Long userId, Long categoryId) {
        log.info("CategoryService.GetAllCategoryByUserIdAndCategoryId - Start - UserId: [{}], CategoryId: [{}]", userId, categoryId);
        var entity = this.searchCategoryByUserIdAndCategoryId(userId, categoryId);
        var response = modelMapper.map(entity, CategoryResponseDTO.class);
        log.info("CategoryService.GetAllCategoryByUserIdAndCategoryId - End - UserId: [{}], CategoryId: [{}], CategoryResponseDTO: [{}]", userId, categoryId, response);
        return response;
    }
}
