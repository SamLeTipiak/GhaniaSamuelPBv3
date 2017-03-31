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

/**
 * <b>DAOClient impl�mente l'interface IDAOClient et contient les m�thodes qui vont permettre la persistence des objets de type client en base de donn�es.</b>
 * <p>Ici sont donc d�finies les m�thodes relatives aux actions sur le client.</p>
 * @author Samuel Bouchet - Ghania Bouzemame
 *@version 3.0
 */
public class DAOClient implements IDAOClient {

	static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

	/* (non-Javadoc)
	 * @see org.formation.dao.IDAOClient#createClient(org.formation.beans.Client)
	 */
	/**
	 * Cette m�thode permet la cr�ation de clients.
	 * @param client
	 */
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
		
	}

	/* (non-Javadoc)
	 * @see org.formation.dao.IDAOClient#updateClient(org.formation.beans.Client)
	 */
	/**
	 * Cette m�thode parmet la modification d'un client donn�.
	 * @param client
	 */
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
		
	}

	/* (non-Javadoc)
	 * @see org.formation.dao.IDAOClient#readClient(long)
	 */
	/**
	 * Cette m�thode permet d'afficher un client en fonction de son id.
	 * @param idClient
	 * @return client
	 */
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
		
		return client;
	}

	/* (non-Javadoc)
	 * @see org.formation.dao.IDAOClient#readList()
	 */
	/**
	 * Cette m�thode permet d'afficher la liste de tous les clients.
	 * @return clients
	 */
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
		System.out.println(clients.get(0));
		return clients;

	}

	/* (non-Javadoc)
	 * @see org.formation.dao.IDAOClient#deleteClient(long)
	 */
	/**
	 * Cette m�thode permet la suppression d'un client donn�.
	 * @param idClient
	 */
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
		

	}

}
