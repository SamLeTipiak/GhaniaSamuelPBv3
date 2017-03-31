package org.formation.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.formation.beans.Account;
import org.formation.dao.IDAOAccount;

/**
 * <b>ServiceAccount implémente l'interface IServiceAccount et contient les méthodes qui vont permettre d'appeler celles de la partie DAO concernant les comptes bancaires.</b>
 * <p>Ici sont donc définies les méthodes propres à la partie Service et relatives aux actions sur les comptes.</p>
 * @author Samuel Bouchet - Ghania Bouzemame
 *@version 3.0
 */
public class ServiceAccount implements IServiceAccount {

	@Inject
	IDAOAccount daoAccount;

	/* (non-Javadoc)
	 * @see org.formation.service.IServiceAccount#createAccount(org.formation.beans.Account)
	 */
	@Override
	public void createAccount(Account account) throws SQLException {
		daoAccount.createAccount(account);

	}

	/* (non-Javadoc)
	 * @see org.formation.service.IServiceAccount#updateAccount(org.formation.beans.Account)
	 */
	@Override
	public void updateAccount(Account account) throws SQLException {
		daoAccount.updateAccount(account);
	}

	/* (non-Javadoc)
	 * @see org.formation.service.IServiceAccount#readListAccount(long)
	 */
	@Override
	public List<Account> readListAccount(long idClient) throws SQLException {
		List<Account> accounts = daoAccount.readListAccount(idClient);
		return accounts;
	}

	/* (non-Javadoc)
	 * @see org.formation.service.IServiceAccount#deleteAccount(long)
	 */
	@Override
	public void deleteAccount(long idClient) throws SQLException {

		daoAccount.deleteAccount(idClient);
	}

}
