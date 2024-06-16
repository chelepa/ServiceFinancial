package br.com.ServiceFinancial.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AccountFilterDTO extends BaseFilter {

    private String name;
    private String userId;
    private String monthId;
    private String year;
    private String categoryId;
    private String subCategoryId;
}
