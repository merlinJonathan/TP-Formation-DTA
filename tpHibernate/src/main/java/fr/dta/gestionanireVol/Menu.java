package fr.dta.gestionanireVol;

import java.util.Scanner;

public class Menu {
	private int numSelectionne;
	private Scanner sc = new Scanner(System.in);
	private Boolean enCoursFonctionnement = true;
	private VolDAO vdao = new VolDAO();
	private ReservationDAO rdao = new ReservationDAO();
	
	public Menu()
	{
		
	}
	
	public void lancerMenu()
	{
		System.out.println("1) Gestion des vols");
		System.out.println("2) Gestion des réservations");
		System.out.println("3) Quitter");
		
		System.out.println("\nEntrez votre choix :");
		numSelectionne = sc.nextInt();
		
		switch(numSelectionne)
		{
			case 1: //appeler le gestionnaire de vol
				menuVol();
				break;
			case 2: // appeler le gestionnaire des reservations
			
				break;
			case 3:
				enCoursFonctionnement = false;
				break;
			default:
				System.out.println("Numero saisie invalide");
				this.lancerMenu();
		}
	}
	
	public void menuVol()
	{
		System.out.println("1) Creer un vol");
		System.out.println("2) Afficher tout les vols");
		System.out.println("3) Afficher les informations d'un vol");
		System.out.println("4) Afficher les entre deux villes");
		
		System.out.println("\nEntrez votre choix :");
		numSelectionne = sc.nextInt();
		
		switch(numSelectionne)
		{
			case 1:
				vdao.creerVol();
				break;
			case 2: // appeler le gestionnaire des reservations
				vdao.afficherToutLesVols();
				break;
			case 3:
				System.out.println("Quel est le numero de vol que vous voulez afficher");
				vdao.afficherInformationVol(sc.nextLine().substring(0, 4));
				
				break;
			case 4:
				
				String villeDepart = null;
				String villeArrive = null;
				boolean egale = false;
				
				System.out.println("Quel est la ville de depart ?");
				villeDepart = sc.nextLine();
				
				while(!egale)
				{
					System.out.println("Quel est la ville d'arrivee ?");
					villeArrive = sc.nextLine();
					if(villeDepart.equals(villeArrive))
					{
						egale = true;
					}
				}
				vdao.afficherVolDecollantA(villeDepart, villeArrive);
				break;
			default:
				System.out.println("Numero saisie invalide");
				this.lancerMenu();
		}
	}


	public int getNumSelectionne() {
		return numSelectionne;
	}

	public void setNumSelectionne(int numSelectionne) {
		this.numSelectionne = numSelectionne;
	}

	public Boolean getEnCoursFonctionnement() {
		return enCoursFonctionnement;
	}

	public void setEnCoursFonctionnement(Boolean enCoursFonctionnement) {
		this.enCoursFonctionnement = enCoursFonctionnement;
	}
	
}
