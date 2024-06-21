package br.com.ServiceFinancial.exceptions;

import br.com.ServiceFinancial.constants.ErrorCodesEnum;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Getter
public class ExceptionResponse implements Serializable {

	@Serial
    private static final long serialVersionUID = 1101390528006902187L;
	
	private final String code;
    private final String message;
    private final List<String> details;
    
    public ExceptionResponse(ErrorCodesEnum errorCode, String details) {
        this.code = errorCode.name();
        this.message = errorCode.getMessage();
        this.details = Collections.singletonList(details);
    }
}

