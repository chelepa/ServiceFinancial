package br.com.ServiceFinancial.converter;

import br.com.ServiceFinancial.dto.account.AccountResponseDTO;
import br.com.ServiceFinancial.dto.user.UserResponseDTO;
import br.com.ServiceFinancial.entity.AccountEntity;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

public class AccountEntityToAccountResponseDTOConverter implements Converter<AccountEntity, AccountResponseDTO> {

    @Override
    public AccountResponseDTO convert(MappingContext<AccountEntity, AccountResponseDTO> context) {
        var destination = Objects.isNull(context.getDestination()) ? new AccountResponseDTO() : context.getDestination();
            destination.setAccountId(context.getSource().getAccountId());
            destination.setAccountDescription(context.getSource().getAccountDescription());
            destination.setAccountValue(context.getSource().getAccountValue());
            destination.setAccountPay(context.getSource().isAccountPay());
            destination.setDatePayment(context.getSource().getDatePayment());
            destination.setAccountId(context.getSource().getAccountId());
            destination.setCategoryId(context.getSource().getCategory().getCategoryId());
            destination.setSubCategoryId(context.getSource().getSubCategory().getSubCategoryId());
            destination.setUserId(context.getSource().getUser().getUserId());
            destination.setMonthsId(context.getSource().getMonths().getMonthsId());
            destination.setYear(context.getSource().getYear().getYear());
        return destination;
    }
}