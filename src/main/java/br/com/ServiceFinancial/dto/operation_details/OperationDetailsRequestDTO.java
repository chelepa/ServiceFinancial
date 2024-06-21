package br.com.ServiceFinancial.dto.operation_details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDetailsRequestDTO {

    private ZonedDateTime operationDetailDate;
    private BigDecimal operationDetailDateValue;
    private Long accountBankId;
    private Long operationTypeId;

}
