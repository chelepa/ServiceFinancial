package br.com.ServiceFinancial.dto.category;

import br.com.ServiceFinancial.dto.sub_category.SubCategoryResponseDTO;
import br.com.ServiceFinancial.dto.user.UserRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "userId" })
public class CategoryResponseDTO {
    private Long categoryId;
    private String categoryName;
    private List<SubCategoryResponseDTO> subCategory = new ArrayList<>();
    private UserRequestDTO userId;
}
