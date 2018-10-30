package fr.dta.gestionanireVol;

import javax.persistence.*;

public class DataHelper {
	   private static EntityManagerFactory entityManagerFactory;

	   public static EntityManager createEntityManager() {
	       if (entityManagerFactory == null) {
	           entityManagerFactory = Persistence.createEntityManagerFactory("gestionnaire_vol");
	       }
	       return entityManagerFactory.createEntityManager();
	   }

	   public static void commitTxAndClose(EntityManager entityManager) {
	       entityManager.getTransaction().commit();
	       entityManager.close();
	   }

	   public static void rollbackTxAndClose(EntityManager entityManager) {
	       entityManager.getTransaction().rollback();
	       entityManager.close();
	   }

	   public static void beginTx(EntityManager entityManager) {
	       entityManager.getTransaction().begin();
	   }
}

