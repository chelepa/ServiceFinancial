package br.com.ServiceFinancial.dto.year;

import br.com.ServiceFinancial.dto.months.MonthsResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YearResponseDTO {
    private long year;
    private List<MonthsResponseDTO> months = new ArrayList<>();
}
