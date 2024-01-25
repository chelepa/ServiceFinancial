package br.com.ServiceFinancial;

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
//		modelMapper.addConverter(new UsersEntityToCustomerDetailsConverter());
//		modelMapper.addConverter(new CustomerRequestDTOToUsersEntityConverter());
//		modelMapper.addConverter(new GroupRequestDTOToGroupEntityConverter());
//		modelMapper.addConverter(new UsersEntityToPasswordResetEntityConverter());
		return modelMapper;
	}
}
