package br.com.ServiceFinancial.dto.account_bank;

import br.com.ServiceFinancial.dto.operation_details.OperationDetailsResponseDTO;
import br.com.ServiceFinancial.dto.user.UserRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountBankDTO {
    private Long accountBankId;
    private String accountBankDescription;
    private List<OperationDetailsResponseDTO> operationDetails;
}
