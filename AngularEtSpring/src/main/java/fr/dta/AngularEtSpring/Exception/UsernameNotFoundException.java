package fr.dta.AngularEtSpring.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus( HttpStatus.NOT_FOUND )
public class UsernameNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

    public UsernameNotFoundException( String message ) {
        super(message);
    }

    public UsernameNotFoundException( String message, Throwable cause ) {
        super( message , cause );
    }
	
}
