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
public class AccountBankResponseDTO {
    private Long accountBankId;
    private String accountBankDescription;
    private UserRequestDTO user;
    private List<OperationDetailsResponseDTO> operationDetails;
}
