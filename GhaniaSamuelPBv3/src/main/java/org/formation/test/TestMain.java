package org.formation.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.formation.beans.Client;
import org.formation.dao.DAOClient;
import org.formation.dao.IDAOClient;
import org.formation.presentation.ClientController;

public class TestMain {
	static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		IDAOClient daoc = new DAOClient();

		Client c1 = new Client("Pringuet", "Mathieu", "3 rue de Navarre", 75016, "Paris", "0602030407");
		Client c2 = new Client("Bouchet", "Samuel", "3 rue des Cocotiers", 75016, "Paris", "0602030405");
		Client c3 = new Client("Bouzemame", "Ghania", "3 all�e des Rosiers", 75016, "Paris", "0602030605");
		Client c4 = new Client("Arthemise", "Jonas", "3 all�e des Cacahu�tes", 75016, "Paris", "0601030605");
		Client c5 = new Client("Cornaton", "Kevin", "3 all�e des Acacias", 75016, "Paris", "0603030605");
		Client c6 = new Client("Potier", "Aurelie", "3 impasse Gueni�vre", 75016, "Paris", "0602030606");

		try {
			txn.begin();

			em.persist(c1);
			em.persist(c2);
			em.persist(c3);
			em.persist(c4);
			em.persist(c5);
			em.persist(c6);

			System.out.println(daoc.readClient(7));

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

		List<Client> clients = new ArrayList<>();
		ClientController clientController = new ClientController(clients);

		clientController.loadClients();
		System.out.println("coucou");
		System.out.println(clientController.getClients().get(1));

		// System.out.println(clientController.readClient(3));

		System.exit(0);

	}

}
