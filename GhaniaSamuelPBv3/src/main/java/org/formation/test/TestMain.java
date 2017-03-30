package org.formation.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.formation.beans.Client;

public class TestMain {
	static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

	public static void main(String[] args) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Client c1 = new Client("Pringuet", "Mathieu", "3 rue de Navarre", 75016, "Paris", "0602030407");
		Client c2 = new Client("Bouchet", "Samuel", "3 rue des Cocotiers", 75016, "Paris", "0602030405");
		Client c3 = new Client("Bouzemame", "Ghania", "3 allée des Rosiers", 75016, "Paris", "0602030605");
		Client c4 = new Client("Arthemise", "Jonas", "3 allée des Cacahuètes", 75016, "Paris", "0601030605");
		Client c5 = new Client("Cornaton", "Kevin", "3 allée des Acacias", 75016, "Paris", "0603030605");
		Client c6 = new Client("Potier", "Aurelie", "3 impasse Guenièvre", 75016, "Paris", "0602030606");
		try {
			txn.begin();

			em.persist(c1);
			em.persist(c2);
			em.persist(c3);
			em.persist(c4);
			em.persist(c5);
			em.persist(c6);
			

			txn.commit();

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		System.exit(0);
	}

}
