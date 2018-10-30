package fr.dta.spring.boot.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class UserValidator implements ConstraintValidator<UserCode, String> {

	 public void initialize(UserCode constraintAnnotation) 
	 { 
		 
	 }
	
	public boolean isValid(String value, ConstraintValidatorContext context) {
			return (value != null && value.equals("bryan"));
	}
}
