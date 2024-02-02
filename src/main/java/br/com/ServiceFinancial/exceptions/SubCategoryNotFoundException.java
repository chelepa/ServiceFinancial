package br.com.ServiceFinancial.exceptions;

public class SubCategoryNotFoundException extends RuntimeException{

    public SubCategoryNotFoundException(String msg) {
        super(msg);
    }
}
