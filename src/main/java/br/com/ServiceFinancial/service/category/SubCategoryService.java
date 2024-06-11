package br.com.ServiceFinancial.service.category;

import br.com.ServiceFinancial.dto.sub_category.SubCategoryRequestDTO;
import br.com.ServiceFinancial.dto.sub_category.SubCategoryResponseDTO;
import br.com.ServiceFinancial.entity.SubCategoryEntity;
import br.com.ServiceFinancial.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SubCategoryService extends BaseService {

    @Autowired
    private ModelMapper modelMapper;

    public SubCategoryResponseDTO createSubCategory(SubCategoryRequestDTO request) {
        log.info("SubCategoryService.createSubCategory - Start - SubCategoryRequestDTO: [{}]", request);
        var entity = modelMapper.map(request, SubCategoryEntity.class);
            entity.setSubCategoryId(null);
        var responseEntity = this.createSubCategoryDB(entity);
        var response = modelMapper.map(responseEntity, SubCategoryResponseDTO.class);
        log.info("SubCategoryService.createSubCategory - End - SubCategoryRequestDTO: [{}]", request);
        return response;
    }

    public List<SubCategoryResponseDTO> getAllSubCategoryByUserId(Long userId, Long categoryId) {
        log.info("SubCategoryService.getAllSubCategoryByUserId - Start - UserId: [{}], CategoryId: [{}]", userId, categoryId);
        var responseEntity = this.getAllSubCategoryByUserIdAndCategoryId(userId, categoryId);
        var responseList = responseEntity.stream().map(item -> modelMapper.map(item, SubCategoryResponseDTO.class)).toList();
        log.info("SubCategoryService.getAllSubCategoryByUserId - End - UserId: [{}], CategoryId: [{}], Response: [{}]", userId, categoryId, responseList);
        return responseList;
    }

    public SubCategoryResponseDTO updateSubCategoryByUserId(Long userId, Long categoryId, Long subCategoryId, SubCategoryRequestDTO request) {
        log.info("SubCategoryService.updateSubCategoryByUserId - Start - UserId: [{}], CategoryId: [{}], subCategoryId: [{}], SubCategoryRequestDTO: [{}]", userId, categoryId, subCategoryId, request);
        var responseEntity = this.getAllSubCategoryByUserIdAndCategoryIdAndSubCategoryId(userId, categoryId, subCategoryId);
            responseEntity.setSubCategoryName(request.getSubCategoryName());
        var update = this.createSubCategoryDB(responseEntity);
        var response = modelMapper.map(update, SubCategoryResponseDTO.class);
        log.info("SubCategoryService.updateSubCategoryByUserId - End - UserId: [{}], CategoryId: [{}], subCategoryId: [{}], SubCategoryRequestDTO: [{}], SubCategoryResponseDTO: [{}]", userId, categoryId, subCategoryId, request, response);
        return response;
    }

    public void deleteSubCategoryByUserId(Long userId, Long categoryId, Long subCategoryId) {
        log.info("SubCategoryService.deleteSubCategoryByUserId - Start - UserId: [{}], CategoryId: [{}], subCategoryId: [{}]", userId, categoryId, subCategoryId);
        var responseEntity = this.getAllSubCategoryByUserIdAndCategoryIdAndSubCategoryId(userId, categoryId, subCategoryId);
        this.deleteSubCategory(responseEntity);
        log.info("SubCategoryService.deleteSubCategoryByUserId - End - UserId: [{}], CategoryId: [{}], subCategoryId: [{}], Status: [DELETED]", userId, categoryId, subCategoryId);
    }
}
