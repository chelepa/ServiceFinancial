package br.com.ServiceFinancial.dto.months;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthsRequestDTO {
    private Long monthsId;
    private String month;
}
