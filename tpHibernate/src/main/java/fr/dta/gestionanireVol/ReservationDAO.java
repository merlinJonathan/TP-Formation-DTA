package fr.dta.gestionanireVol;

import javax.persistence.EntityManager;

public class ReservationDAO extends GenericDAO<Reservation>{
	
	public ReservationDAO()
	{
		super(Reservation.class);
	}
	

	public void reserverVol(Reservation r, Vol v)
	{
		VolDAO vdao = new VolDAO();
		EntityManager em = DataHelper.createEntityManager();
		try
		{
			DataHelper.beginTx(em);
			
			r.reserver(v);
			v.reserverPlace(r);
		
			this.merge(r);
			vdao.merge(v);
			
			DataHelper.commitTxAndClose(em);
		}
		catch(Exception E)
		{
			DataHelper.rollbackTxAndClose(em);
		}
	}
	
	public void annulerReservation(String numReservation)
	{
		String sql = new String("SELECT r "
				+ "FROM Reservation r "
				+ "WHERE numeroReservation = :chaineCaractere");
		
		Reservation r = this.findSingleByString(sql, numReservation);
		
		this.remove(r.getId());
		
	}
	
}
