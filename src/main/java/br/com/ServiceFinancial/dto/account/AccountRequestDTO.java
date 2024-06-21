package br.com.ServiceFinancial.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestDTO {

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
