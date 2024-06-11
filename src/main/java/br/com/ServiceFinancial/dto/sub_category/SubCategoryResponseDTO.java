package br.com.ServiceFinancial.dto.sub_category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoryResponseDTO {

    private Long subCategoryId;
    private String subCategoryName;
}
