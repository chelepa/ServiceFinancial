package br.com.ServiceFinancial.dto.user;

import br.com.ServiceFinancial.dto.account_bank.AccountBankDTO;
import br.com.ServiceFinancial.dto.account_bank.AccountBankResponseDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserResponseDTO {
    private Long userId;
    private List<AccountBankDTO> accountBank;
}
