package fr.dta.spring.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ExceptionBryan extends RuntimeException {
	public ExceptionBryan() {
	}
}
