package fr.dta.spring.boot.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.spring.boot.exception.ExceptionBryan;
import fr.dta.spring.boot.model.User;

@RestController
public class UserController {

	@PostMapping("/user")
	public User creerUser(@RequestBody @Valid User user) {
		return user;
	}
	
	@GetMapping("/user")
	public User afficherUser()
	{
		return new User("michelle");
	}

	@GetMapping("/user/{tag}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String creerUser(@PathVariable String tag)       {
		String result = "";
		
		try {
			if(!tag.equals("bryan")) {
				throw new ExceptionBryan();
			}else {
				result+="WELCOME BRYAN";
			}
		}catch(ExceptionBryan e) {
			result+="PAS BRYAN";
		}finally {
			
		}
		
		
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		Validator validator = factory.getValidator();
//		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
//		
//		if (constraintViolations != null) {
//			for (ConstraintViolation<User> violation : constraintViolations) {
//				result += violation.getMessage() + "\n";
//			}
//		}
		return result;
	}
	
	@PostMapping("/userp")
	public String creerUserPost(@RequestBody String tag) {
		String result = "";
		
		try {
			if(!tag.equals("bryan")) {
				throw new ExceptionBryan();
			}else {
				result+="WELCOME BRYAN";
			}
		}catch(ExceptionBryan e) {
			result+="PAS BRYAN";
		}finally {
			
		}
		
		
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		Validator validator = factory.getValidator();
//		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
//		
//		if (constraintViolations != null) {
//			for (ConstraintViolation<User> violation : constraintViolations) {
//				result += violation.getMessage() + "\n";
//			}
//		}
		return result;
	}
}
