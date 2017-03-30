package org.formation.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.formation.beans.Client;

public class DAOClient implements IDAOClient {

	static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

	@Override
	public void createClient(Client client) throws SQLException {

		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();

			em.persist(client);

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

	@Override
	public void updateClient(Client client) throws SQLException {

		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();

			em.merge(client);

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

	@Override
	public Client readClient(long idClient) throws SQLException {

		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Client client = new Client();

		try {
			txn.begin();

			client = em.find(Client.class, idClient);

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
		return client;
	}

	@Override
	public List<Client> readList() throws SQLException {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		List<Client> clients = new ArrayList<>();

		try {
			txn.begin();

			TypedQuery<Client> query = em.createQuery("from Client", Client.class);
			clients = query.getResultList();

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
		return clients;

	}

	@Override
	public void deleteClient(long idClient) throws SQLException {

		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Client client = new Client();
		
		try {
			txn.begin();

			client = em.find(Client.class, idClient);
			em.remove(client);

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
