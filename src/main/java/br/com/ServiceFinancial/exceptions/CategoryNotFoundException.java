package br.com.ServiceFinancial.exceptions;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(String msg) {
        super(msg);
    }
}
