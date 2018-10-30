package fr.dta.spring.boot.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UserValidator.class)
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserCode {
	 String message() default "where is bryan ?";
	 Class<?>[] groups() default {};
	 Class<? extends Payload>[] payload() default {}; 
}
