package org.formation.beans;

import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.formation.dao.DAOClient;

/**
 * <b>Adviser représente les différents conseillers d'une agence.</b>
 * <p>Cette classe étend la classe Actor et hérite donc de ses propriétés. Chaque conseiller est aussi caractérisé par :</p>
 * <p>idAdviser : un identifiant généré automatiquement (par incrémentation) au niveau de la base de données.</p>
 * <p>De plus, chaque conseiller a aussi une liste de clients (au plus 10).
 * </p>
 * @see Adviser#addClient(Client)
 * @see DAOClient#deleteClient(long)
 * @author Samuel Bouchet - Ghania Bouzemame
 * @version 3.0
 *
 */
@ManagedBean
@Entity
public class Adviser extends Actor{

	
	@OneToMany(mappedBy="adviser", cascade= CascadeType.ALL)
	private Set<Client>clients = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name="agence_id")
	private Agence agence;
	
	
	
	public Agence getAgence() {
		return agence;
	}



	public void setAgence(Agence agence) {
		this.agence = agence;
	}



	/**
	 * addClientToAdviser() permet d'associer un client à un conseiller donné.
	 * @param client
	 */
	public void addClientToAdviser(Client client) {
		client.setAdviser(this);
		this.clients.add(client);
		
		
		
	}

	
	
}
