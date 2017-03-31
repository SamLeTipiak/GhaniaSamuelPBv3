package org.formation.beans;

import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.formation.dao.DAOAccount;

/**
 * <b>Client représente les clients de la banque.</b>
 * <p>Cette classe étend la classe Actor et hérite donc de ses propriétés.</p>
 * <p>Chaque client est aussi caractérisé par les informations suivantes :
 * <ul>
 * <li>idClient : un identifiant généré automatiquement (par incrémentation à partir de 1) par la base de données</li>
 * <li>address : son adresse physique</li>
 * <li>zipcode : le code postal</li>
 * <li>city : la ville</li>
 * <li>phoneNumber : son numéro de téléphone</li>
 * </ul>
 * </p>
 * <p>Chaque client a aussi une liste de comptes qu'il est possible de modifier.</p>
 * @see Client#addAccount(Account)
 * @see DAOAccount#deleteAccount(long)
 * @author Bouchet Samuel - Ghania Bouzemame
 * @version 3.0
 *
 */
@ManagedBean
@Entity
public class Client extends Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idClient;

	private String address;
	private int zipCode;
	private String city;
	private String phoneNumer;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private Set<Account> accounts = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name="agence_id")
	private Agence agence;
	
	@ManyToOne
	@JoinColumn(name="adviser_id")
	private Adviser adviser;

	public Client() {
		super();
	}

	public Client(String address, int zipCode, String city, String phoneNumer) {
		super();
		
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.phoneNumer = phoneNumer;
	}

	public Client(String address, int zipCode, String city, String phoneNumer,
			Set<Account> accounts) {
		super();
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.phoneNumer = phoneNumer;
		this.accounts = accounts;
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

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
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

	/**
	 * addAccount() permet d'associer un compte à un client donné.
	 * @param account
	 */
	public void addAccount(Account account) {

		account.setClient(this);
		this.accounts.add(account);
	}

	@Override
	public String toString() {
		return "Client [address=" + address + ", zipCode="
				+ zipCode + ", city=" + city + ", phoneNumer=" + phoneNumer + "]";
	}

}
