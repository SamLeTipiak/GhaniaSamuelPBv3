package org.formation.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.formation.beans.Account;

public class DAOAccount implements IDAOAccount{

	static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
	
	@Override
	public void createAccount(Account account) throws SQLException {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
	}

	@Override
	public void updateAccount(Account account) throws SQLException {
	
		
	}

	@Override
	public List<Account> readListAccount(long idClient) throws SQLException {
		
		return null;
	}

	@Override
	public void deleteAccount(long idClient) throws SQLException {
		
		
	}

}
