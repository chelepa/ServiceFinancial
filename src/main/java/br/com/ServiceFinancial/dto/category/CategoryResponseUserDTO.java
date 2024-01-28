package br.com.ServiceFinancial.dto.category;

import br.com.ServiceFinancial.dto.sub_category.SubCategoryResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseUserDTO {

    private Long id;
    private String name;
    private List<SubCategoryResponseDTO> listSubCategory;

}
