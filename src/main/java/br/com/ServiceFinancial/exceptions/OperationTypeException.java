package br.com.ServiceFinancial.exceptions;

public class OperationTypeException extends RuntimeException{

    public OperationTypeException(String msg) {
        super(msg);
    }
}
