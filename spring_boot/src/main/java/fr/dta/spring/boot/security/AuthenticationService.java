package fr.dta.spring.boot.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fr.dta.spring.boot.dao.UserDAO;
import fr.dta.spring.boot.model.User;

public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		Optional<User> option = userDAO.findOneByLogin(username);
		if(option.isPresent()) {
			User user = option.get();
			List<GrantedAuthority> rules = this.getUserCredentials(user);
			return new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(),rules);
		}
		throw new UsernameNotFoundException("username.not.found");
	}

	public List<GrantedAuthority> getUserCredentials(User user)
	{
		List<GrantedAuthority> liste = new ArrayList<>();
		liste.add(new SimpleGrantedAuthority(user.getRole()));
		return liste;
	}

}
