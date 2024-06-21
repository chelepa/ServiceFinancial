package br.com.ServiceFinancial.exceptions;

public class AccountBankException extends RuntimeException{

    public AccountBankException(String msg) {
        super(msg);
    }
}
