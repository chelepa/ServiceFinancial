package br.com.ServiceFinancial.dto.users;

import br.com.ServiceFinancial.dto.category.CategoryResponseUserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private Long id;
    private List<CategoryResponseUserDTO> category;
}
