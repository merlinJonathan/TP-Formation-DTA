package fr.dta.gestionanireVol;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Reservation {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	private String numeroReservation;
	
	@NotBlank
	private String nom;
	
	@NotBlank
	private String prenom;
	
	@NotNull
	private int age;
	
	@ManyToOne
	private Vol volReserve;

	public Reservation()
	{
		
	}
	
	public Reservation(String nom, String prenom, int age)
	{
		this.numeroReservation = "aucune";
		this.nom = nom;
		this.prenom = prenom;
		this.age = age ;
	}
	
	/* Getters & setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public String getNumeroReservation() {
		return numeroReservation;
	}

	public void setNumeroReservation(String numeroReservation) {
		this.numeroReservation = numeroReservation;
	}

	public Vol getVolsReserves() {
		return volReserve;
	}

	public void setVolsReserves(Vol volsReserves) {
		this.volReserve = volsReserves;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void reserver(Vol v)
	{
		this.setNumeroReservation(new String(v.getNumeroVol() + "-" + this.getId()));
		this.volReserve = v;
	}
	
	
	public String toString()
	{
		return new String(numeroReservation + " | " + nom + " | " + prenom + " | " + age);
	}
	
	public boolean equals(Reservation r)
	{
		if(this.numeroReservation.equals(r.numeroReservation))
			return true;
		else
			return false;
	}
}
