package br.com.ServiceFinancial.constants;

import lombok.Getter;

@Getter
public enum ErrorCodesEnum {

	USER_NOT_FOUND("USER_NOT_FOUND"),
	ACCOUNT_BANK_NOT_FOUND("ACCOUNT_BANK_NOT_FOUND"),
	OPERATION_DETAILS_NOT_FOUND("OPERATION_DETAILS_NOT_FOUND"),
	CATEGORY_NOT_FOUND("CATEGORY_NOT_FOUND"),
	SUB_CATEGORY_NOT_FOUND("SUB_CATEGORY_NOT_FOUND"),
	ACCOUNT_NOT_FOUND("ACCOUNT_NOT_FOUND"),
	OPERATION_TYPE_NOT_FOUND("OPERATION_TYPE_NOT_FOUND");

	private final String message;
	
	ErrorCodesEnum(String message) {
		this.message = message;
	}

}