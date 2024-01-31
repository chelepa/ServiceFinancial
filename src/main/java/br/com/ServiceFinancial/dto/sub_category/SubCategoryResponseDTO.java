package br.com.ServiceFinancial.dto.sub_category;

import br.com.ServiceFinancial.dto.expenses_and_income.ExpensesAndIncomeResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryResponseDTO {

    private Long id;
    private String name;
    private List<ExpensesAndIncomeResponseDTO> expensesAndIncome;
}
