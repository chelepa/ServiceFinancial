package br.com.ServiceFinancial.exceptions;

public class ExpensesAndIncomeNotFoundException extends RuntimeException{

    public ExpensesAndIncomeNotFoundException(String msg) {
        super(msg);
    }
}
