package fr.dta.AngularEtSpring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import fr.dta.AngularEtSpring.Enum.EnumRole;

@Entity
public class MyUser extends IdEntity{

	@Id
	@GeneratedValue
	private long id;

	@Column 
	private String nom;
	
	@Column 
	private String password;
	
	@Column
	private String role ;
	
	public MyUser()
	{
		this("nom", "password", EnumRole.ROLE_USER.getRole());
	}
	
	public MyUser(String nom, String password, String role)
	{
		this.nom = nom;
		this.password = password;
		this.role = role;
	}

	public long getId() {
		return id;
	} 

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "MyUser [id=" + id + ", nom=" + nom + ", password=" + password + "]";
	}
}
