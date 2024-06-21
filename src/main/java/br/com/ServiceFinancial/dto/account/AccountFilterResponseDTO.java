package br.com.ServiceFinancial.dto.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountFilterResponseDTO {

    private Integer page;
    private Integer size;
    private Integer totalPages;
    private Integer totalItem;
    private BigDecimal value;
    public List<AccountResponseDTO> accounts;
}
