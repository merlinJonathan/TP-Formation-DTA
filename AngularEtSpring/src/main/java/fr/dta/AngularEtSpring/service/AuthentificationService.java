package fr.dta.AngularEtSpring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.dta.AngularEtSpring.Enum.EnumRole;
import fr.dta.AngularEtSpring.dao.MyUserDAO;
import fr.dta.AngularEtSpring.model.MyUser;

@Service
@Transactional
public class AuthentificationService implements UserDetailsService{

	@Autowired
	private MyUserDAO myuserdao;
	
	@Override
	public UserDetails loadUserByUsername(final String username) {
		Optional<MyUser> option = myuserdao.findOneByLogin(username);
		if (option.isPresent()) {
			MyUser user = option.get();
			List<GrantedAuthority> rules = this.getUserCredentials(user);
			return new org.springframework.security.core.userdetails.User(user.getNom(), user.getPassword(), rules);
		}
		throw new UsernameNotFoundException("username.not.found");
	}

	private List<GrantedAuthority> getUserCredentials(MyUser user) {
		 List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		 
		 authorities.add(new SimpleGrantedAuthority(EnumRole.ROLE_USER.getRole()));
		 if(user.getRole().equals(EnumRole.ROLE_ADMIN.getRole()))
		 {
			 authorities.add(new SimpleGrantedAuthority(EnumRole.ROLE_ADMIN.getRole()));
		 }
		 
		return authorities;
	}

}
