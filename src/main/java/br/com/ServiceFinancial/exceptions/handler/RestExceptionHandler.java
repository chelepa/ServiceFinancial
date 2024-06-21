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
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<Object> handleUserException(UserException msg){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodesEnum.USER_NOT_FOUND, msg.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(OperationTypeException.class)
    public ResponseEntity<Object> handleOperationTypeException(OperationTypeException msg){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodesEnum.OPERATION_TYPE_NOT_FOUND, msg.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(AccountBankException.class)
    public ResponseEntity<Object> handleAccountBankException(AccountBankException msg){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodesEnum.ACCOUNT_BANK_NOT_FOUND, msg.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(OperationDetailsException.class)
    public ResponseEntity<Object> handleOperationDetailsException(OperationDetailsException msg){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodesEnum.OPERATION_DETAILS_NOT_FOUND, msg.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(CategoryException.class)
    public ResponseEntity<Object> handleCategoryException(CategoryException msg){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodesEnum.CATEGORY_NOT_FOUND, msg.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(SubCategoryException.class)
    public ResponseEntity<Object> handleSubCategoryException(SubCategoryException msg){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodesEnum.SUB_CATEGORY_NOT_FOUND, msg.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(AccountException.class)
    public ResponseEntity<Object> handleAccountException(AccountException msg){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodesEnum.ACCOUNT_NOT_FOUND, msg.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }
}
