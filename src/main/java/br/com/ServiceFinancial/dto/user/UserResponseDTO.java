package br.com.ServiceFinancial.dto.user;

import br.com.ServiceFinancial.dto.account_bank.AccountBankResponseDTO;
import br.com.ServiceFinancial.dto.category.CategoryResponseDTO;
import br.com.ServiceFinancial.entity.CategoryEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserResponseDTO {
    private Long userId;
    private List<AccountBankResponseDTO> accountBank = new ArrayList<>();
    private List<CategoryResponseDTO> category = new ArrayList<>();
}
