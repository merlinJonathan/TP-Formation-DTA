package fr.dta.spring.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import fr.dta.spring.boot.validator.UserCode;

@Entity
public class User extends IdEntity{	
	@Column
	@UserCode
	private String nom;
	
	@Column
	private String login;
	
	@Column
	private String password;
	
	@Column
	private String role;
	
	public User()
	{
		this("");
	}
	
	public User(String nom)
	{
		this.nom = nom ;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogin() {
		return this.login;
	}

	public String getPassword() {
		return this.password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
