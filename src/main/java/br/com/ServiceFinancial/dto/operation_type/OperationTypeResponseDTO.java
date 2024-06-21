package br.com.ServiceFinancial.dto.operation_type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationTypeResponseDTO {
    private Long operationTypeId;
    private String operationTypeDescription;
}
