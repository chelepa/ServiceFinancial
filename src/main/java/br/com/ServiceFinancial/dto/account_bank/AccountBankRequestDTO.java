package br.com.ServiceFinancial.dto.account_bank;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AccountBankRequestDTO {
    private String accountBankDescription;
    private BigDecimal accountBankValue;
    private Long userId;
}
