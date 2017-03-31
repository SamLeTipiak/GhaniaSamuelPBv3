package org.formation.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.formation.beans.Account;
import org.formation.dao.IDAOAccount;

public class ServiceAccount implements IServiceAccount {

	@Inject
	IDAOAccount daoAccount;

	@Override
	public void createAccount(Account account) throws SQLException {
		daoAccount.createAccount(account);

	}

	@Override
	public void updateAccount(Account account) throws SQLException {
		daoAccount.updateAccount(account);
	}

	@Override
	public List<Account> readListAccount(long idClient) throws SQLException {
		List<Account> accounts = daoAccount.readListAccount(idClient);
		return accounts;

	}

	@Override
	public void deleteAccount(long idClient) throws SQLException {

		daoAccount.deleteAccount(idClient);
	}

}
