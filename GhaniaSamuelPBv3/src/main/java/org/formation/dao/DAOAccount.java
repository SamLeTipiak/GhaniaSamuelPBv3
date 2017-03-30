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

public class DAOAccount implements IDAOAccount {

	static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

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

	@Override
	public void deleteAccount(long idAccount) throws SQLException {

		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Account account = new Account();

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
