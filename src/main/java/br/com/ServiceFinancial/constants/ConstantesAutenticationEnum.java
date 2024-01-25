package br.com.ServiceFinancial.constants;

public enum ConstantesAutenticationEnum {

	AUTHORIZATION("Authorization"),
	BEARER("Bearer "),
	ROLES_CLAIM ("Roles"),
	FULL_NAME("fullName"),
	ROLE("ROLE_");

	private final String message;

	ConstantesAutenticationEnum(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}