package br.com.ServiceFinancial.dto.months;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthsRequestDTO {

    private String name;
    private Long year;
}
