package br.com.ServiceFinancial.exceptions;

public class YearNotFoundException extends RuntimeException{

    public YearNotFoundException(String msg) {
        super(msg);
    }
}
