package fr.dta.gestionanireVol;

import java.time.LocalDate;


public class Main {
	public static void main(String[] args) {
		VolDAO vdao = new VolDAO();
		ReservationDAO rdao = new ReservationDAO();
		Menu menu = new Menu();
		
		while(menu.getEnCoursFonctionnement())
		{
			menu.lancerMenu();
			
			/*Vol v1 = new Vol("0001", EnumAvion.A330, 10, "Montpellier", "Paris", LocalDate.now());
			Vol v2 = new Vol("0002", EnumAvion.A330, 10, "Marseille", "New york", LocalDate.now());
	
			Reservation r1 = new Reservation("Merlin", "Jonathan", 23);
			Reservation r2 = new Reservation("jean", "michel", 45);
			Reservation r3 = new Reservation("jean-michel", "crapaud", 54);	
			
			
			vdao.persist(v1);
			vdao.persist(v2);
			
			
			rdao.persist(r1);
			rdao.persist(r2);
			rdao.persist(r3);
	
			rdao.reserverVol(r1, v1);
			rdao.reserverVol(r2, v1);
			rdao.reserverVol(r3, v2);
			
			vdao.afficherInformationVol("0002");
			vdao.afficherVolDecollantA("Marseille", "New york");
			rdao.annulerReservation(r3.getNumeroReservation());*/
		}
		
		System.out.println("\nFin de l'execution du programme");
	}
}
