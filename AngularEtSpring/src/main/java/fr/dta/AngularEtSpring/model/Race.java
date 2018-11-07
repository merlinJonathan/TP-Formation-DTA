package fr.dta.AngularEtSpring.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Race extends IdEntity{
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String location;
	
	@Column
	private Date date;
	
	@Column
	@OneToMany
	private List<Pony> ponies;
	
	public Race()
	{
		this("lieu", new Date());
	}
	
	public Race(String location, Date date)
	{
		ponies = new ArrayList<Pony>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Pony> getPonies() {
		return ponies;
	}

	public void setPonies(List<Pony> ponies) {
		this.ponies = ponies;
	}

	@Override
	public String toString() {
		return "Race [id=" + id + ", location=" + location + ", date=" + date + ", ponies=" + ponies + "]";
	}
	
}
