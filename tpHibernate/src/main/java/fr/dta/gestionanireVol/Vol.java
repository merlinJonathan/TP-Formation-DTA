package fr.dta.gestionanireVol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Vol {
	@Id
	@GeneratedValue()
	private Long id;
	
	@NotBlank
	private String numeroVol; //essayer davoir "0001"
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private EnumAvion typeAvion;
	
	@NotNull
	private int nbPlace;

	@NotNull
	private String villeDepart;
	
	@NotNull
	private String villeArrive;
	
	@NotNull
	private Date dateDepart;
	
	@OneToMany(mappedBy = "volReserve")
	private List<Reservation> placeReserve = new ArrayList<Reservation>();

	public Vol()
	{
		
	}
	
	public Vol(String numVol, EnumAvion typeAvion, int nbPlace, String villeDepart, String villeArrive, Date dateDepart)
	{
		this.numeroVol = numVol;
		this.typeAvion = typeAvion;
		this.nbPlace = nbPlace;
		this.villeDepart = villeDepart;
		this.villeArrive = villeArrive;
		this.dateDepart = dateDepart;
	}
	
	public String toString()
	{
		return new String(numeroVol + " | " + typeAvion + " | " + nbPlace + " | " + villeDepart + " | " + villeArrive + " | " + dateDepart);
	}
	
	/* Getters & setters */
	public String getNumeroVol() {
		return numeroVol;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNumeroVol(String numéroVol) {
		this.numeroVol = numéroVol;
	}

	public EnumAvion getTypeAvion() {
		return typeAvion;
	}

	public void setTypeAvion(EnumAvion typeAvion) {
		this.typeAvion = typeAvion;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrive() {
		return villeArrive;
	}

	public void setVilleArrive(String villeArrive) {
		this.villeArrive = villeArrive;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public void reserverPlace(Reservation r)
	{
		this.placeReserve.add(r);
	}
	
	public void annulerReservationPlace(Reservation r)
	{
		// recuperation de l'index
		int index = -1;
		boolean trouver = false;
		
		Iterator it = placeReserve.iterator();
		
		while(it.hasNext())
		{
			Reservation r1 = (Reservation) it.next();
			if(r1.equals(r))
				trouver = true;
			index++;
		}
		if(trouver)
			this.placeReserve.remove(index);
		else
			System.out.println(r);
	}
	
	public boolean equals(Vol v)
	{
		if(this.id == v.id)
			return true;
		else
			return false;
			
	}
}
