package org.formation.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CurrentAccount extends Account {
	private static float CURRENTRATE=0.00f;

	@OneToOne(mappedBy="currentAccount", cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private Client client;

	public CurrentAccount() {
		super();
	}

	public CurrentAccount(double sold, String openDate) {
		super(sold, openDate);
		super.accountRate=CURRENTRATE;
	}

	public CurrentAccount(long accountNumber, double sold, String openDate) {
		super(accountNumber, sold, openDate);
		super.accountRate=CURRENTRATE;
	}

	public CurrentAccount(long idAccount, long accountNumber, double sold, String openDate) {
		super(idAccount, accountNumber, sold, openDate);
		super.accountRate=CURRENTRATE;

	}
	
}
