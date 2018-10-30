package fr.dta.spring.boot.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.spring.boot.model.User;

@Repository
@Transactional
public class UserDAO extends GenericDAO<User>{

	public UserDAO() {
		super(User.class);
	}

	public Optional<User> findOneByLogin(String username) {
		
		return null;
	}
	

	
	
}
