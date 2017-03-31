package org.formation.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.formation.beans.Account;

/**
 * <b>DAOAccount implémente l'interface IDAOAccount et contient les méthodes qui vont permettre la persistence des objets de type compte en base de données.</b>
 * <p>Ici sont donc définies les méthodes relatives aux actions sur les comptes.</p>
 * @author Samuel Bouchet - Ghania Bouzemame
 *@version 3.0
 */
public class DAOAccount implements IDAOAccount {

	static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

	/* (non-Javadoc)
	 * @see org.formation.dao.IDAOAccount#createAccount(org.formation.beans.Account)
	 */
	/**
	 * Cette méthode permet de créer un compte.
	 * @param account
	 */
	@Override
	public void createAccount(Account account) throws SQLException {

		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();

			em.persist(account);

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
	 * @see org.formation.dao.IDAOAccount#updateAccount(org.formation.beans.Account)
	 */
	/**
	 * Cette méthode permet la modification d'un compte donné.
	 * @param account
	 */
	@Override
	public void updateAccount(Account account) throws SQLException {

		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();

			em.merge(account);

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
	 * @see org.formation.dao.IDAOAccount#readListAccount(long)
	 */
	/**
	 * Cette méthode permet d'afficher la liste des comptes d'un client donné.
	 * @param idClient
	 * @return accounts
	 */
	@Override
	public List<Account> readListAccount(long idClient) throws SQLException {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		List<Account> accounts = new ArrayList<>();

		try {
			txn.begin();

			TypedQuery<Account> query = em.createQuery("from Account", Account.class);

			accounts = query.getResultList();

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

		return accounts;

	}

	/* (non-Javadoc)
	 * @see org.formation.dao.IDAOAccount#deleteAccount(long)
	 */
	/**
	 * Cette méthode permet la suppression de comptes.
	 * @param idAccount
	 */
	@Override
	public void deleteAccount(long idAccount) throws SQLException {

		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Account account;

		try {
			txn.begin();

			account = em.find(Account.class, idAccount);
			em.remove(account);

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
