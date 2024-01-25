package br.com.ServiceFinancial.constants;

import lombok.Getter;

@Getter
public enum ErrorCodesEnum {

	INTERNAL_SERVER_ERROR("Internal server error"),
	NOT_FOUND("Not found"),
	BAD_REQUEST("Bad request");

	private final String message;
	
	ErrorCodesEnum(String message) {
		this.message = message;
	}

}