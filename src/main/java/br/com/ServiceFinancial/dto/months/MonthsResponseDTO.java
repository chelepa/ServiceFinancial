package br.com.ServiceFinancial.dto.months;

import br.com.ServiceFinancial.dto.expenses_and_income.ExpensesAndIncomeResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthsResponseDTO {

    private Long id;
    private String name;
    private BigDecimal valueRevenues;
    private BigDecimal valueExpenses;
    private List<ExpensesAndIncomeResponseDTO> expensesAndIncome;
}
