package br.com.ServiceFinancial.exceptions;

public class MonthsNotFoundException extends RuntimeException{

    public MonthsNotFoundException(String msg) {
        super(msg);
    }
}
