package org.formation.dao;

import java.sql.SQLException;
import java.util.List;

import org.formation.beans.Account;

/**
 *Sont d�clar�es dans cette interface toutes les m�thodes propres � la partie DAO et qui sont relatives aux actions sur les comptes. Elles sont d�finies dans la classe {@link DAOAccount}.
 *@see DAOAccount#createAccount(Account)
 *@see DAOAccount#updateAccount(Account)
 *@see DAOAccount#readListAccount(long)
 *@see DAOAccount#deleteAccount(long)
 * @author Samuel Bouchet - Ghania Bouzemame
 * @version 3.0
 *
 */
public interface IDAOAccount {
	
	public void createAccount(Account account) throws SQLException;
	
	public void updateAccount(Account account) throws SQLException;
	
	public List<Account> readListAccount(long idClient) throws SQLException;
	
	public void deleteAccount(long idClient) throws SQLException;

}
