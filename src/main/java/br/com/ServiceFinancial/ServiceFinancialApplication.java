package br.com.ServiceFinancial;

import br.com.ServiceFinancial.converter.AccountEntityToAccountResponseDTOConverter;
import br.com.ServiceFinancial.converter.UserEntityToUserResponseDTOConverter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceFinancialApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceFinancialApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		modelMapper.addConverter(new UserEntityToUserResponseDTOConverter());
		modelMapper.addConverter(new AccountEntityToAccountResponseDTOConverter());
		return modelMapper;
	}
}
