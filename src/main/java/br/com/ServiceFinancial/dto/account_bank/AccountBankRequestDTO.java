package br.com.ServiceFinancial.dto.account_bank;

import br.com.ServiceFinancial.dto.operation_details.OperationDetailsRequestDTO;
import br.com.ServiceFinancial.dto.user.UserRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountBankRequestDTO {
    private String accountBankDescription;
    private UserRequestDTO user;
    private List<OperationDetailsRequestDTO> operationDetails = new ArrayList<>();
}
