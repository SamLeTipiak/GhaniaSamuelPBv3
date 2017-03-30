package org.formation.beans;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@ManagedBean
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private static long accountNumber;
	private double sold;
	private String openDate;
	private enum type {
		SavingAccount, CurrentAccount;
	}
	protected type accountType;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="client_id")
	private Client client;
	
	public Account() {
		super();

	}


	public Account(long id, long accountNumber, double sold, String openDate) {
		super();
		this.id = id;
		Account.accountNumber = accountNumber;
		this.sold = sold;
		this.openDate = openDate;
	}


	public Account(long accountNumber, double sold, String openDate) {
		super();
		Account.accountNumber = accountNumber;
		this.sold = sold;
		this.openDate = openDate;
	}


	public static long getAccountNumber() {
		return accountNumber;
	}


	public double getSold() {
		return sold;
	}


	public String getOpenDate() {
		return openDate;
	}


	public static void setAccountNumber(long accountNumber) {
		Account.accountNumber = accountNumber;
	}


	public void setSold(double sold) {
		this.sold = sold;
	}


	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}
	
	

}
