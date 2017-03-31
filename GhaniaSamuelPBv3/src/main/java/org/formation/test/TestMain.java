package org.formation.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.formation.beans.Client;
import org.formation.beans.CurrentAccount;
import org.formation.beans.SavingAccount;

public class TestMain {
	static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

	public static void main(String[] args) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

//		Account sac1 = new Account(5644.34, "565");
//		Account cac2 = new Account(545, 545.22, "445564");
		
		SavingAccount sa1 = new SavingAccount(123, 35.4, "46465");
		CurrentAccount ca1 = new CurrentAccount(456, 4648644.5464, "lundi");
		Client client1 = new Client(1, "curie", "pierre", "45 rue belle", 45645, "paris", "124578996", sa1, ca1);

	
		
//		Set<Account> accounts = new HashSet<>();
	

		try {
			txn.begin();
			
			// em.persist(c1);
			// em.persist(c2);
			// em.persist(c3);
			// em.persist(c4);
			// em.persist(c5);
			// em.persist(c6);
//			em.persist(ac1);
			// client1.setAc(ac1);
			// em.persist(client1);

			client1.setSavingAccount(sa1);
			client1.setCurrentAccount(ca1);
			em.persist(client1);
			
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

	}

}
