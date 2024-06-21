package br.com.ServiceFinancial.service.operation;

import br.com.ServiceFinancial.dto.operation_type.OperationTypeResponseDTO;
import br.com.ServiceFinancial.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OperationTypeService extends BaseService {

    @Autowired
    private ModelMapper modelMapper;

    public OperationTypeResponseDTO getOperationTypeById(Long id) {
        log.info("OperationType.GetOperationTypeById - Start - Id: [{}] ", id);
        var entity = this.searchOperationTypeById(id);
        var response = modelMapper.map(entity, OperationTypeResponseDTO.class);
        log.info("OperationType.GetOperationTypeById - End - Id: [{}] OperationTypeResponseDTO: [{}]", id, response);
        return response;
    }

    public List<OperationTypeResponseDTO> getAllOperationType() {
        log.info("OperationType.GetAllOperationType - Start - ");
        var entity = this.searchAllOperationType();
        var responseList = entity.stream().map(item -> modelMapper.map(item, OperationTypeResponseDTO.class)).toList();
        log.info("OperationType.GetAllOperationType - End - ResponseList: [{}]", responseList);
        return responseList;
    }
}
