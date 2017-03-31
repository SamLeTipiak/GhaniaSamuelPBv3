package org.formation.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.formation.beans.Account;
import org.formation.beans.Client;
import org.formation.service.IServiceAccount;

@ManagedBean
@SessionScoped
public class AccountController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	IServiceAccount serviceAccount;

	private List<Account> accounts = new ArrayList<>();
//	Account account = new Account();

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
	
public String loadAccount(int idClient) {
		
		try {

			List<Account> accounts  = serviceClient.readClient(idClient);

			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("accounts", accounts);

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

		return "update.xhtml";
	}

}
