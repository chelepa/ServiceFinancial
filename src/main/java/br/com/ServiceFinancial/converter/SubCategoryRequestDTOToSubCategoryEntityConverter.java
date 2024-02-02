package br.com.ServiceFinancial.converter;

import br.com.ServiceFinancial.dto.sub_category.SubCategoryRequestDTO;
import br.com.ServiceFinancial.entity.SubCategoryEntity;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.util.Objects;

public class SubCategoryRequestDTOToSubCategoryEntityConverter implements Converter<SubCategoryRequestDTO, SubCategoryEntity> {

    @Override
    public SubCategoryEntity convert(MappingContext<SubCategoryRequestDTO, SubCategoryEntity> context) {
        SubCategoryEntity destination =  Objects.isNull(context.getDestination()) ? new SubCategoryEntity() : context.getDestination();
        destination.setId(null);
        destination.setName(context.getSource().getName() == null ? destination.getName() : context.getSource().getName());
        return destination;
    }
}
