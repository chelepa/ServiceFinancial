package br.com.ServiceFinancial.converter;

import br.com.ServiceFinancial.dto.category.CategoryRequestDTO;
import br.com.ServiceFinancial.entity.CategoryEntity;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.util.ArrayList;
import java.util.Objects;

public class CategoryRequestDTOToCategoryEntityConverter implements Converter<CategoryRequestDTO, CategoryEntity> {

    @Override
    public CategoryEntity convert(MappingContext<CategoryRequestDTO, CategoryEntity> context) {
        CategoryEntity destination =  Objects.isNull(context.getDestination()) ? new CategoryEntity() : context.getDestination();
        destination.setId(null);
        destination.setName(context.getSource().getName() == null ? destination.getName() : context.getSource().getName());
        destination.setListSubCategory(new ArrayList<>());
        return destination;
    }
}
