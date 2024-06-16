package br.com.ServiceFinancial.specification;

import br.com.ServiceFinancial.dto.filter.AccountFilterDTO;
import br.com.ServiceFinancial.entity.AccountEntity;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@AllArgsConstructor
public class SpecificationAccountByFilter {

    private static final String FIELD_NAME = "accountDescription";
    private static final List<String> FIELD_USER = List.of("user", "userId");
    private static final List<String> FIELD_MONTHS = List.of("months", "monthsId");
    private static final List<String> FIELD_YEAR = List.of("year", "year");
    private static final List<String> FIELD_CATEGORY = List.of("category", "categoryId");
    private static final List<String> FIELD_SUB_CATEGORY = List.of("subCategory", "subCategoryId");
    private static final String PERCENT = "%";

    private static String concatPercent(String value) {
        return PERCENT.concat(value).concat(PERCENT);
    }

    public static Specification<AccountEntity> findByCriteria(AccountFilterDTO filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.isNotEmpty(filter.getName())) {
                predicates.add(cb.like(cb.lower(root.get(FIELD_NAME)), concatPercent(filter.getName().toLowerCase())));
            }
            if (StringUtils.isNotEmpty(filter.getYear())) {
                predicates.add(cb.equal(root.get(FIELD_YEAR.get(0)).get(FIELD_YEAR.get(1)), filter.getYear()));
            }
            if (StringUtils.isNotEmpty(filter.getUserId())) {
                predicates.add(cb.equal(root.get(FIELD_USER.get(0)).get(FIELD_USER.get(1)), filter.getUserId()));
            }
            if (StringUtils.isNotEmpty(filter.getMonthId())) {
                predicates.add(cb.equal(root.get(FIELD_MONTHS.get(0)).get(FIELD_MONTHS.get(1)), filter.getMonthId()));
            }
            if (StringUtils.isNotEmpty(filter.getCategoryId())) {
                predicates.add(cb.equal(root.get(FIELD_CATEGORY.get(0)).get(FIELD_CATEGORY.get(1)), filter.getCategoryId()));
            }
            if (StringUtils.isNotEmpty(filter.getSubCategoryId())) {
                predicates.add(cb.equal(root.get(FIELD_SUB_CATEGORY.get(0)).get(FIELD_SUB_CATEGORY.get(1)), filter.getSubCategoryId()));
            }
            return cb.and(predicates.toArray(new Predicate[] {}));
        };
    }
}
