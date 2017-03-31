package org.formation.beans;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 * <b>Account représente les comptes bancaires ouverts chez ProxiBanque.</b>
 * <p>Chaque compte est caractérisé par les informations suivantes :
 * <ul>
 * <li>idAccount : un identifiant généré automatiquement au niveau de la base de données</li>
 * <li>accountNumber : le numéro de compte</li>
 * <li>sold : le solde du compte</li>
 * <li>openDate : la date d'ouverture du compte</li>
 * <li>accountRate : la rémunération du compte</li>
 * </ul>
 * </p>
 * <p>Chaque compte est aussi associé à un client.</p>
 * @author Bouchet Samuel - Ghania Bouzemame
 * @version 3.0
 *
 */
@ManagedBean
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long idAccount;
	private static long accountNumber;
	private double sold;
	private String openDate;

	protected double accountRate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="client_id")
	private Client client;
	
	public Account() {
		super();

	}


	public Account(long idAccount, long accountNumber, double sold, String openDate) {
		super();
		this.idAccount = idAccount;
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

	

	public Account(double sold, String openDate) {
		super();
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


	public double getAccountRate() {
		return accountRate;
	}


	public void setAccountRate(double accountRate) {
		this.accountRate = accountRate;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public long getIdAccount() {
		return idAccount;
	}
	



}
