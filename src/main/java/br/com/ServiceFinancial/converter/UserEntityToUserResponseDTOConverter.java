package br.com.ServiceFinancial.converter;

import br.com.ServiceFinancial.dto.account_bank.AccountBankResponseDTO;
import br.com.ServiceFinancial.dto.category.CategoryResponseDTO;
import br.com.ServiceFinancial.dto.operation_details.OperationDetailsResponseDTO;
import br.com.ServiceFinancial.dto.operation_type.OperationTypeResponseDTO;
import br.com.ServiceFinancial.dto.sub_category.SubCategoryResponseDTO;
import br.com.ServiceFinancial.dto.user.UserResponseDTO;
import br.com.ServiceFinancial.entity.*;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserEntityToUserResponseDTOConverter implements Converter<UserEntity, UserResponseDTO> {

    @Override
    public UserResponseDTO convert(MappingContext<UserEntity, UserResponseDTO> context) {
        UserResponseDTO destination = Objects.isNull(context.getDestination()) ? new UserResponseDTO() : context.getDestination();
        destination.setUserId(context.getSource().getUserId());
        destination.setAccountBank(convertAccountBank(context.getSource().getAccountBank()));
        destination.setCategory(convertCategory(context.getSource().getCategory()));
        return destination;
    }

    private List<CategoryResponseDTO> convertCategory(List<CategoryEntity> category) {
        List<CategoryResponseDTO> response = new ArrayList<>();
        category.forEach(item -> {
            var request = new CategoryResponseDTO();
                request.setCategoryId(item.getCategoryId());
                request.setCategoryName(item.getCategoryName());
                request.setSubCategory(convertSubCategory(item.getSubCategory()));
            response.add(request);
        });
        return response;
    }

    private List<SubCategoryResponseDTO> convertSubCategory(List<SubCategoryEntity> subCategory) {
        List<SubCategoryResponseDTO> response = new ArrayList<>();
        subCategory.forEach(item -> {
            var request = new SubCategoryResponseDTO();
                request.setSubCategoryId(item.getSubCategoryId());
                request.setSubCategoryName(item.getSubCategoryName());
            response.add(request);
        });
        return response;
    }

    private List<AccountBankResponseDTO> convertAccountBank(List<AccountBankEntity> accountBank) {
        List<AccountBankResponseDTO> response = new ArrayList<>();
        accountBank.forEach(item -> {
            var update = new AccountBankResponseDTO();
                update.setAccountBankId(item.getAccountBankId());
                update.setAccountBankDescription(item.getAccountBankDescription());
                update.setAccountBankValue(item.getAccountBankValue());
                update.setOperationDetails(convertOperationDetails(item.getOperationDetails()));
            response.add(update);
        });
        return response;
    }

    private List<OperationDetailsResponseDTO> convertOperationDetails(List<OperationDetailsEntity> operationDetails) {
        List<OperationDetailsResponseDTO> response = new ArrayList<>();
        operationDetails.forEach(item -> {
            var details = new OperationDetailsResponseDTO();
                details.setOperationDetailId(item.getOperationDetailId());
                details.setOperationDetailDate(item.getOperationDetailDate());
                details.setOperationDetailDateValue(item.getOperationDetailDateValue());
                details.setOperationType(new OperationTypeResponseDTO(item.getOperationType().getOperationTypeId(), item.getOperationType().getOperationTypeDescription()));
            response.add(details);
        });
        return response;
    }
}
