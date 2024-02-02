package br.com.ServiceFinancial.dto.expenses_and_income;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpensesAndIncomeResponseDTO {

    private Long id;
    private boolean expenses;
    private boolean revenues;
    private String description;
    private BigDecimal value;
    private boolean paidOut;
    private String paymentDate;
}
