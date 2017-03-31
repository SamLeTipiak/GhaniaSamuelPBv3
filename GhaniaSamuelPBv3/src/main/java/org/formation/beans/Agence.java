package org.formation.beans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.formation.dao.DAOClient;

/**
 * <b>Agence repr�sente les diff�rentes agences du r�seau ProxiBanque.</b>
 * <p>Chacune est caract�ris�e par :
 * <ul>
 * <li>idAgence : un identifiant g�n�r� automatiquement (par incr�mentation � partir de 1) au niveau de la base de donn�es.</li>
 * <li>creationDate : sa date de cr�ation</li>
 * </p>
 * <p>De plus, chaque agence a aussi une liste de conseillers et une autre de clients qui peuvent chacune �tre modifi�es.
 * </p>
 * @see Agence#addAdviser(Adviser)
 * @see Agence#addClient(Client)
 * @see DAOClient#deleteClient(long)
 * @author Samuel Bouchet - Ghania Bouzemame
 * @version 3.0
 *
 */
@ManagedBean
@Entity
public class Agence {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idAgence;
	private String creationDate;
	
	@OneToMany(mappedBy="agence", cascade=CascadeType.ALL)
	private List<Adviser> advisers = new ArrayList<>();
	
	@OneToMany(mappedBy="agence", cascade=CascadeType.ALL)
	private Set<Client>clients = new HashSet<>();
	
	public Agence() {
		super();
	}
	public Agence(long idAgence, String creationDate) {
		super();
		this.idAgence = idAgence;
		this.creationDate = creationDate;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public List<Adviser> getAdvisers() {
		return advisers;
	}
	public void setAdvisers(List<Adviser> advisers) {
		this.advisers = advisers;
	}
	public Set<Client> getClients() {
		return clients;
	}
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	
	
	/**
	 * addClientToAgence() permet d'associer un client � une agence donn�e.
	 * @param client
	 */
	public void addClientToAgence(Client client) {

		client.setAgence(this);
		this.clients.add(client);
	}
	
	/**
	 * addAdviser() permet d'associer un conseill� � une agence donn�e.
	 * @param adviser
	 */
	public void addAdviser(Adviser adviser) {

		adviser.setAgence(this);
		this.advisers.add(adviser);
	}
	@Override
	public String toString() {
		return "Agence [idAgence=" + idAgence + ", creationDate=" + creationDate + "]";
	}
	
	

}
