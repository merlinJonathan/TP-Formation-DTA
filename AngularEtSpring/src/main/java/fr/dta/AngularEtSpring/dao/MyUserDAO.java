package fr.dta.AngularEtSpring.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.AngularEtSpring.model.MyUser;
import fr.dta.AngularEtSpring.model.Pony;

@Repository
@Transactional
public class MyUserDAO extends GenericDAO<MyUser>{

	public MyUserDAO() {
		super(MyUser.class);
	}

	public Optional<MyUser> findOneByLogin(String username) {
		return this.findBySQL("from MyUser where upper(nom) = upper(:nom)", username);
	}
}
