package org.formation.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.formation.beans.Account;
import org.formation.service.IServiceAccount;
import org.formation.service.ServiceAccount;

@ManagedBean
@SessionScoped
public class AccountController implements Serializable {

	private static final long serialVersionUID = 1L;

	IServiceAccount serviceAccount = new ServiceAccount();

	private List<Account> accounts = new ArrayList<>();
	Account account = new Account();

	public AccountController() {
		super();
	}

	public AccountController(List<Account> accounts) {
		super();
		this.accounts = accounts;
	}

	public void createAccount(Account account) {

		try {

			serviceAccount.createAccount(account);

		} catch (Exception e) {

		}

	}

	public void updateAccount(Account account) {

		try {

			serviceAccount.updateAccount(account);

		} catch (Exception e) {

		}

	}

	public void loadAccounts(long idClient) {
		accounts.clear();

		try {
			accounts = serviceAccount.readListAccount(idClient);

		} catch (Exception e) {
			e.getMessage();

		} finally {

		}
	}

	public void deleteAccount(long idClient) {
		try {
			serviceAccount.deleteAccount(idClient);
		} catch (Exception e) {
		} finally {

		}

	}

	public List<Account> getAccounts() {
		return accounts;
	}

}
