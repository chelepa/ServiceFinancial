package br.com.ServiceFinancial.exceptions;

public class AccountException extends RuntimeException{

    public AccountException(String msg) {
        super(msg);
    }
}
