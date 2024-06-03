package br.com.ServiceFinancial.dto.account_bank;

import br.com.ServiceFinancial.dto.operation_details.OperationDetailsResponseDTO;
import br.com.ServiceFinancial.dto.user.UserRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "user" })
public class AccountBankResponseDTO {
    private Long accountBankId;
    private String accountBankDescription;
    private BigDecimal accountBankValue;
    private UserRequestDTO user;
    private List<OperationDetailsResponseDTO> operationDetails;
}
