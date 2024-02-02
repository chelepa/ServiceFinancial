package br.com.ServiceFinancial.exceptions.handler;

import br.com.ServiceFinancial.constants.ErrorCodesEnum;
import br.com.ServiceFinancial.exceptions.*;
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

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException msg){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodesEnum.NOT_FOUND, msg.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}

	@ExceptionHandler(SubCategoryNotFoundException.class)
	public ResponseEntity<Object> handleSubCategoryNotFoundException(SubCategoryNotFoundException msg){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodesEnum.NOT_FOUND, msg.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}

	@ExceptionHandler(YearNotFoundException.class)
	public ResponseEntity<Object> handleYearNotFoundException(YearNotFoundException msg){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodesEnum.NOT_FOUND, msg.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}

	@ExceptionHandler(MonthsNotFoundException.class)
	public ResponseEntity<Object> handleMonthsNotFoundException(MonthsNotFoundException msg){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodesEnum.NOT_FOUND, msg.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}

	@ExceptionHandler(ExpensesAndIncomeNotFoundException.class)
	public ResponseEntity<Object> handleExpensesAndIncomeNotFoundException(ExpensesAndIncomeNotFoundException msg){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodesEnum.NOT_FOUND, msg.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}
}
