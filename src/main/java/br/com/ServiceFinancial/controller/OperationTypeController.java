package br.com.ServiceFinancial.controller;

import br.com.ServiceFinancial.dto.operation_type.OperationTypeResponseDTO;
import br.com.ServiceFinancial.service.FinancialService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OperationTypeController {

    private final FinancialService financialService;

    @GetMapping(value = "/v1/operation/type/{id}")
    public ResponseEntity<OperationTypeResponseDTO> getOperationTypeById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(financialService.getOperationTypeById(id));
    }

    @GetMapping(value = "/v1/operation/type")
    public ResponseEntity<List<OperationTypeResponseDTO>> getAllOperationType(){
        return ResponseEntity.status(HttpStatus.OK).body(financialService.getAllOperationType());
    }
}
