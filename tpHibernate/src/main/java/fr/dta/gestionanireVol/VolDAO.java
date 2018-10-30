package fr.dta.gestionanireVol;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class VolDAO extends GenericDAO<Vol>{

	public VolDAO()
	{
		super(Vol.class);
	}
	
	public void afficherInformationVol(String numVol)
	{
		String sql = new String("SELECT v "
		+ "FROM Vol v " 
		+ "WHERE v.numeroVol = :chaineCaractere");

		Vol v = this.findSingleByString(sql, numVol);
		
		System.out.println(v);
	}
	

	public void afficherVolDecollantA(String villeDepart, String villeArrive)
	{
		String sql = new String("SELECT v "
				+ "FROM Vol v "
				+ "WHERE v.villeDepart = :villeDepart AND v.villeArrive = :villeArrive");
		
		EntityManager em = DataHelper.createEntityManager();
		
		TypedQuery<Vol> query = em.createQuery(sql, Vol.class);

		query.setParameter("villeDepart", villeDepart);
		query.setParameter("villeArrive", villeArrive);
		
		List<Vol> vols = query.getResultList();
		
		for (Vol vol : vols) {
			System.out.println(vol);
		}
	}
	
	public Vol getNumeroVol(Reservation r)
	{
		String s = new String(r.getNumeroReservation());
		s = s.substring(0, 4);
		String sql = new String("SELECT v "
				+ "FROM Vol v "
				+ "WHERE v.numeroVol = :chaineCaractere");
		
		
		return this.findSingleByString(sql, s);
	}

	public void afficherToutLesVols()
	{
		String sql = new String("SELECT v FROM Vol v");
		
		EntityManager em = DataHelper.createEntityManager();
		
		TypedQuery<Vol> query = em.createQuery(sql, Vol.class);
			
		List<Vol> vols =  query.getResultList();
		for (Vol vol : vols) {
			System.out.println(vol);
		}
	}
	
	
	public void creerVol() 
	{
		Scanner sc = new Scanner(System.in);
		String numVol = null;
		EnumAvion ea = null;
		int nbPlace = 0;
		String villeDepart = null;
		String villeArrivee = null;
		Date date = new Date();
		SimpleDateFormat simpledateformat = new SimpleDateFormat("DD/MM/YYYY", Locale.FRANCE);
		String tmp;
		int int_tmp;
		boolean validationSaisie = false;
		System.out.println("Création d'un vol :");

		// saisie du numero de vol
		while(!validationSaisie)
		{
			System.out.println("Quel est le numéro de vol ? ");
			int_tmp = Integer.parseInt(sc.nextLine());
			if(int_tmp > 1000 || int_tmp <= 0)
			{
				System.out.println("Le numero de vol saisie est invalide");
			}
			else
			{
				if(int_tmp < 10)
					numVol = new String("000" + int_tmp);
				else if(int_tmp < 100)
					numVol = new String("00" + int_tmp);
				else if(int_tmp < 1000)
					numVol = new String("0" + int_tmp);
				else
					numVol = new String("" + int_tmp);
				validationSaisie = true;
			}
		}
		
		
		// saisie du type de l'avion
		validationSaisie = false;
		while(!validationSaisie)
		{
			System.out.println("Quel est l'avion ?");
			tmp = sc.nextLine();
			switch(tmp.toString())
			{
				case "A330" :
						ea = EnumAvion.A330;
						validationSaisie = true;
						break;
				case "A340" :
						ea = EnumAvion.A340;
						validationSaisie = true;
						break;
				case "A380" :
						ea = EnumAvion.A380;
						validationSaisie = true;
						break;
				case "B747" :
						ea = EnumAvion.B747;
						validationSaisie = true;
						break;
				default:
					System.out.println("Le type d'avion saisie n'éxiste pas");
			}
		}

		// saisie du nombre de place disponible durant le vol
		validationSaisie = false;
		while(!validationSaisie)
		{
			System.out.println("Combien y à t-il de place au maximum ?");
			int_tmp = Integer.parseInt(sc.nextLine());
			if(int_tmp > 0)
			{
				nbPlace = int_tmp;
				validationSaisie = true;
			}
		}
		

		// saisie de la ville de depart
		validationSaisie = false;
		while(!validationSaisie)
		{
			System.out.println("Quel est la ville de départ ?");
			villeDepart = sc.nextLine();
			validationSaisie = true;
		}

		// saisie de la ville d'arrivé
		validationSaisie = false;
		while(!validationSaisie)
		{
			System.out.println("Quel est la ville d'arrivée du vol ?");
			tmp = sc.nextLine();
			if(tmp.equals(villeDepart))
			{
				System.out.println("Veuillez saisir une ville d'arrivée différente de la ville de départ");
			}
			else
			{
				villeArrivee = new String("tmp");
				validationSaisie = true;
			}
		}
		
		
		// saisie de la date de depart
		validationSaisie = false;
		while(!validationSaisie)
		{
			System.out.println("Quand aura lieu de départ du vol ? ");
			try {
				date = simpledateformat.parse(sc.nextLine());
				validationSaisie = true;
			}catch(ParseException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		Vol v = new Vol(numVol, ea, nbPlace, villeDepart, villeArrivee, date);
		this.persist(v);
	}	
}
