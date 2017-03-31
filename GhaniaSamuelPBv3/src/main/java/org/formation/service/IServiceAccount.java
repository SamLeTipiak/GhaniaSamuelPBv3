package org.formation.service;

import java.sql.SQLException;
import java.util.List;

import org.formation.beans.Account;

/**
 *Sont d�clar�es dans cette interface toutes les m�thodes propres � la partie Service et relatives aux actions sur les comptes. Elles sont d�finies dans la classe {@link ServiceAccount}.
 *@see ServiceAccount#createAccount(Account)
 *@see ServiceAccount#updateAccount(Account)
 *@see ServiceAccount#readListAccount(long)
 *@see ServiceAccount#deleteAccount(long)
 * @author Samuel Bouchet - Ghania Bouzemame
 * @version 3.0
 *
 */
public interface IServiceAccount {

	public void createAccount(Account account) throws SQLException;

	public void updateAccount(Account account) throws SQLException;

	public List<Account> readListAccount(long idClient) throws SQLException;

	public void deleteAccount(long idClient) throws SQLException;

}
