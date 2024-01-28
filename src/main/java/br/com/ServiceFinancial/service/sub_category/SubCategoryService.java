package br.com.ServiceFinancial.service.sub_category;

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
        var category = this.searchCategoryById(request.getCategoryId());
            entity.setCategory(category);
        var responseEntity = this.saveSubCategory(entity);
        var response = modelMapper.map(responseEntity, SubCategoryResponseDTO.class);
        log.info("SubCategoryService.createSubCategory - End - SubCategoryResponseDTO: [{}]", response);
        return response;
    }

    public SubCategoryResponseDTO getSubCategoryById(Long id) {
        log.info("SubCategoryService.getSubCategoryById - Start - Id: [{}]", id);
        var responseEntity = this.searchSubCategoryRepository(id);
        var response = modelMapper.map(responseEntity, SubCategoryResponseDTO.class);
        log.info("SubCategoryService.getSubCategoryById - End - Id: [{}] SubCategoryResponseDTO: [{}]", id, response);
        return response;
    }

    public List<SubCategoryResponseDTO> getAllSubCategory() {
        log.info("SubCategoryService.getAllSubCategory - Start - ");
        var listSubCategory = this.searchAllSubCategory();
        var response = listSubCategory.stream().map(category -> modelMapper.map(category, SubCategoryResponseDTO.class)).toList();
        log.info("SubCategoryService.getAllSubCategory - End - List SubCategoryResponseDTO: [{}]", response);
        return response;
    }

    public void deleteSubCategory(Long id) {
        log.info("SubCategoryService.deleteSubCategory - Start - Id: [{}]", id);
        var entity = this.searchSubCategoryRepository(id);
        this.removeSubCategory(entity);
        log.info("SubCategoryService.deleteSubCategory - End - id: [{}] - Deleted", id);
    }

    public SubCategoryResponseDTO updateSubCategoryById(Long id, SubCategoryRequestDTO request) {
        log.info("SubCategoryService.updateSubCategoryById - Start - Id: [{}] SubCategoryRequestDTO: [{}]", id, request);
        var entity = this.searchSubCategoryRepository(id);
        modelMapper.map(request, entity);
        entity.setId(id);
        var newEntity = this.saveSubCategory(entity);
        var response = modelMapper.map(newEntity, SubCategoryResponseDTO.class);
        log.info("SubCategoryService.updateSubCategoryById - End - Id: [{}] CategoryRequestDTO: [{}] CategoryResponseDTO: [{}]",  id, request, response);
        return response;
    }
}
