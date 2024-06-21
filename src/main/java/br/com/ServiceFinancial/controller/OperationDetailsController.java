package br.com.ServiceFinancial.controller;

import br.com.ServiceFinancial.dto.operation_details.OperationDetailsRequestDTO;
import br.com.ServiceFinancial.dto.operation_details.OperationDetailsResponseDTO;
import br.com.ServiceFinancial.service.FinancialService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class OperationDetailsController {

    private final FinancialService financialService;

    @PostMapping(value = "/v1/operation/details")
    public ResponseEntity<OperationDetailsResponseDTO> createOperationDetails(@RequestBody OperationDetailsRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(financialService.createOperationDetails(request));
    }

    @GetMapping(value = "/v1/operation/details/{userId}/{accountBankId}")
    public ResponseEntity<List<OperationDetailsResponseDTO>> getOperationDetailsByUserIdAndAccountId(@PathVariable("userId") Long userId, @PathVariable("accountBankId") Long accountBankId){
        return ResponseEntity.status(HttpStatus.OK).body(financialService.getOperationDetailsByUserIdAndAccountId(userId, accountBankId));
    }

    @GetMapping(value = "/v1/operation/details/{userId}/{accountBankId}/{operationTypeId}")
    public ResponseEntity<List<OperationDetailsResponseDTO>> getOperationDetailsByUserIdAndAccountIdAndOperationTypeId(@PathVariable("userId") Long userId, @PathVariable("accountBankId") Long accountBankId, @PathVariable("operationTypeId") Long operationTypeId){
        return ResponseEntity.status(HttpStatus.OK).body(financialService.getOperationDetailsByUserIdAndAccountIdAndOperationTypeId(userId, accountBankId, operationTypeId));
    }

    @PutMapping(value = "/v1/operation/details/{userId}/{accountBankId}/{operationDetailsId}")
    public ResponseEntity<OperationDetailsResponseDTO> updateOperationDetailsByUserIdAndAccountId(@PathVariable("userId") Long userId, @PathVariable("accountBankId") Long accountBankId, @PathVariable("operationDetailsId") Long operationDetailsId, @RequestBody OperationDetailsRequestDTO request){
        return ResponseEntity.status(HttpStatus.OK).body(financialService.updateOperationDetailsByUserIdAndAccountId(userId, accountBankId, operationDetailsId, request));
    }

    @DeleteMapping(value = "/v1/operation/details/{userId}/{accountBankId}/{operationDetailsId}")
    public ResponseEntity<Void> deleteOperationDetailsByUserIdAndAccountId(@PathVariable("userId") Long userId, @PathVariable("accountBankId") Long accountBankId, @PathVariable("operationDetailsId") Long operationDetailsId){
        financialService.deleteOperationDetailsByUserIdAndAccountId(userId, accountBankId, operationDetailsId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
