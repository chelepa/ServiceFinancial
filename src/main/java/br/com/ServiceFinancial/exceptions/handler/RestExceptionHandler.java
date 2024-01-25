package br.com.ServiceFinancial.exceptions.handler;

import br.com.ServiceFinancial.constants.ErrorCodesEnum;
import br.com.ServiceFinancial.exceptions.CategoryNotFoundException;
import br.com.ServiceFinancial.exceptions.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<Object> handleCategoryNotFoundException(CategoryNotFoundException msg){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodesEnum.NOT_FOUND, msg.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}
}
