package br.com.ServiceFinancial;

import br.com.ServiceFinancial.converter.CategoryRequestDTOToCategoryEntityConverter;
import br.com.ServiceFinancial.converter.SubCategoryRequestDTOToSubCategoryEntityConverter;
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
		modelMapper.addConverter(new CategoryRequestDTOToCategoryEntityConverter());
		modelMapper.addConverter(new SubCategoryRequestDTOToSubCategoryEntityConverter());
//		modelMapper.addConverter(new GroupRequestDTOToGroupEntityConverter());
//		modelMapper.addConverter(new UsersEntityToPasswordResetEntityConverter());
		return modelMapper;
	}
}
