package br.com.ServiceFinancial.dto.operation_details;

import br.com.ServiceFinancial.dto.operation_type.OperationTypeResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDetailsResponseDTO {

    private Long operationDetailId;
    private ZonedDateTime operationDetailDate;
    private BigDecimal operationDetailDateValue;
    private OperationTypeResponseDTO operationType;
}