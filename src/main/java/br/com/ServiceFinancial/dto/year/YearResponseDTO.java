package br.com.ServiceFinancial.dto.year;

import br.com.ServiceFinancial.dto.months.MonthsResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YearResponseDTO {

    private Long id;
    private Long year;
    private List<MonthsResponseDTO> months;
}
