package br.com.ServiceFinancial.dto.sub_category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoryRequestDTO {

    private String subCategoryName;
    private Long categoryId;
}
