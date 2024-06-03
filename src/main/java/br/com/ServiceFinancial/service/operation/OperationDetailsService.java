package br.com.ServiceFinancial.service.operation;

import br.com.ServiceFinancial.dto.operation_details.OperationDetailsRequestDTO;
import br.com.ServiceFinancial.dto.operation_details.OperationDetailsResponseDTO;
import br.com.ServiceFinancial.entity.OperationDetailsEntity;
import br.com.ServiceFinancial.entity.OperationTypeEntity;
import br.com.ServiceFinancial.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OperationDetailsService extends BaseService {

    @Autowired
    private ModelMapper modelMapper;

    public OperationDetailsResponseDTO createOperationDetails(OperationDetailsRequestDTO request) {
        log.info("OperationDetailsService.createOperationDetails - Start - OperationDetailsRequestDTO: [{}]", request);
        var entityRequest = modelMapper.map(request, OperationDetailsEntity.class);
        var entity = this.createOperationDetailsDB(entityRequest);
        var response = modelMapper.map(entity, OperationDetailsResponseDTO.class);
        log.info("OperationDetailsService.createOperationDetails - End - OperationDetailsRequestDTO: [{}], OperationDetailsResponseDTO: [{}]", request, response);
        return response;
    }

    public List<OperationDetailsResponseDTO> getOperationDetailsByUserIdAndAccountId(Long userId, Long accountBankId) {
        log.info("OperationDetailsService.getOperationDetailsByUserIdAndAccountId - Start - userId: [{}], accountBankId: [{}]", userId, accountBankId);
        var entity = this.searchOperationDetailsByUserIdAndAccountId(accountBankId, userId);
        var responseList = entity.stream().map(item -> modelMapper.map(item, OperationDetailsResponseDTO.class)).toList();
        log.info("OperationDetailsService.getOperationDetailsByUserIdAndAccountId - Start - userId: [{}], accountBankId: [{}], Response: [{}]", userId, accountBankId, responseList);
        return responseList;
    }

    public List<OperationDetailsResponseDTO> getOperationDetailsByUserIdAndAccountIdAndOperationTypeId(Long userId, Long accountBankId, Long operationTypeId) {
        log.info("OperationDetailsService.getOperationDetailsByUserIdAndAccountIdAndOperationTypeId - Start - userId: [{}], accountBankId: [{}], operationTypeId: [{}]", userId, accountBankId, operationTypeId);
        var entity = this.searchOperationDetailsByUserIdAndAccountIdAndOperationTypeId(accountBankId, userId, operationTypeId);
        var responseList = entity.stream().map(item -> modelMapper.map(item, OperationDetailsResponseDTO.class)).toList();
        log.info("OperationDetailsService.getOperationDetailsByUserIdAndAccountIdAndOperationTypeId - End - userId: [{}], accountBankId: [{}], operationTypeId: [{}] Response: [{}]", userId, accountBankId, operationTypeId, responseList);
        return responseList;
    }

    public OperationDetailsResponseDTO updateOperationDetailsByUserIdAndAccountId(Long userId, Long accountBankId, Long operationDetailsId, OperationDetailsRequestDTO request) {
        log.info("OperationDetailsService.updateOperationDetailsByUserIdAndAccountId - Start - userId: [{}], accountBankId: [{}], OperationDetailsRequestDTO: [{}]", userId, accountBankId, request);
        var entityRequest = this.searchOperationDetailsByUserIdAndAccountIdAndOperationDetailId(accountBankId, userId, operationDetailsId);
            entityRequest.setOperationType(new OperationTypeEntity());
        modelMapper.map(request, entityRequest);
            entityRequest.setOperationDetailId(operationDetailsId);
        var entity = this.createOperationDetailsDB(entityRequest);
        var response = modelMapper.map(entity, OperationDetailsResponseDTO.class);
        log.info("OperationDetailsService.updateOperationDetailsByUserIdAndAccountId - End - userId: [{}], accountBankId: [{}], OperationDetailsRequestDTO: [{}], Response: [{}]", userId, accountBankId, request, response);
        return response;
    }

    public void deleteOperationDetailsByUserIdAndAccountId(Long userId, Long accountBankId, Long operationDetailsId) {
        log.info("OperationDetailsService.updateOperationDetailsByUserIdAndAccountId - Start - userId: [{}], accountBankId: [{}], operationDetailsId: [{}]", userId, accountBankId, operationDetailsId);
        var entityRequest = this.searchOperationDetailsByUserIdAndAccountIdAndOperationDetailId(accountBankId, userId, operationDetailsId);
        this.deleteOperationDetailsByUserIdAndAccountIdDB(entityRequest);
        log.info("OperationDetailsService.updateOperationDetailsByUserIdAndAccountId - End - userId: [{}], accountBankId: [{}], operationDetailsId: [{}], [DELETED]", userId, accountBankId, operationDetailsId);
    }
}
