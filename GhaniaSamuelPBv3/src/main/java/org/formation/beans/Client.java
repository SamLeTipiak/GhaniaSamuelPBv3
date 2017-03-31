package org.formation.beans;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.formation.dao.DAOAccount;

/**
 * <b>Client représente les clients de la banque.</b>
 * <p>
 * Cette classe étend la classe Actor et hérite donc de ses propriétés.
 * </p>
 * <p>
 * Chaque client est aussi caractérisé par les informations suivantes :
 * <ul>
 * <li>address : son adresse physique</li>
 * <li>zipcode : le code postal</li>
 * <li>city : la ville</li>
 * <li>phoneNumber : son numéro de téléphone</li>
 * </ul>
 * </p>
 * <p>
 * Chaque client a aussi une liste de comptes qu'il est possible de modifier.
 * </p>
 * 
 * @see Client#addAccount(Account)
 * @see DAOAccount#deleteAccount(long)
 * @author Bouchet Samuel - Ghania Bouzemame
 * @version 3.0
 *
 */
@ManagedBean
@Entity
public class Client extends Actor {

	private String address;
	private int zipCode;
	private String city;
	private String phoneNumer;

	@OneToOne(cascade = CascadeType.ALL)
	private SavingAccount savingAccount;
	// private Set<Account> accounts = new HashSet<>();

	@OneToOne(cascade = CascadeType.ALL)
	private CurrentAccount currentAccount;

	@ManyToOne
	@JoinColumn(name = "agence_id")
	private Agence agence;

	@ManyToOne
	@JoinColumn(name = "adviser_id")
	private Adviser adviser;

	public Client() {
		super();

	}

	public Client(long idAgence, String lastName, String firstName) {
		super(idAgence, lastName, firstName);
	}

	public Client(String lastName, String firstName) {
		super(lastName, firstName);
	}

	public Client(long idAgence, String lastName, String firstName, String address, int zipCode, String city,
			String phoneNumer) {
		super(idAgence, lastName, firstName);

		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.phoneNumer = phoneNumer;
	}

	public Client(long idAgence, String lastName, String firstName, String address, int zipCode, String city, String phoneNumer, SavingAccount savingAccount,
			CurrentAccount currentAccount) {
		super(idAgence, lastName, firstName);
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.phoneNumer = phoneNumer;
		this.savingAccount = savingAccount;
		this.currentAccount = currentAccount;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumer() {
		return phoneNumer;
	}

	public void setPhoneNumer(String phoneNumer) {
		this.phoneNumer = phoneNumer;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public Adviser getAdviser() {
		return adviser;
	}

	public void setAdviser(Adviser adviser) {
		this.adviser = adviser;
	}





	public SavingAccount getSavingAccount() {
		return savingAccount;
	}

	public void setSavingAccount(SavingAccount savingAccount) {
		this.savingAccount = savingAccount;
	}

	public CurrentAccount getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(CurrentAccount currentAccount) {
		this.currentAccount = currentAccount;
	}

	@Override
	public String toString() {
		return "Client [address=" + address + ", zipCode=" + zipCode + ", city=" + city + ", phoneNumer=" + phoneNumer
				+ "]";
	}

}
