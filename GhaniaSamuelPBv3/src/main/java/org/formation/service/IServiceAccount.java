package org.formation.service;

import java.sql.SQLException;
import java.util.List;

import org.formation.beans.Account;

public interface IServiceAccount {

	public void createAccount(Account account) throws SQLException;

	public void updateAccount(Account account) throws SQLException;

	public List<Account> readListAccount(long idClient) throws SQLException;

	public void deleteAccount(long idClient) throws SQLException;

}
