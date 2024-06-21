package br.com.ServiceFinancial.dto.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AccountResponseDTO {

    private Long accountId;
    private String accountDescription;
    private BigDecimal accountValue;
    private boolean accountPay;
    private ZonedDateTime datePayment;
    private Long categoryId;
    private Long subCategoryId;
    private Long userId;
    private Long monthsId;
    private Long year;
}
