package org.formation.beans;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * <b>Actor représente les différents acteurs au sein d'une agence.</b>
 * <p>
 * Chacun est caractérisé par les informations suivantes :
 * <ul>
 * <li>idAgence : l'identifiant de l'agence à laquelle il est rattaché.</li>
 * <li>lastName : son nom de famille</li>
 * <li>firstName : son prénom</li>
 * </ul>
 * </p>
 * 
 * @author Samuel Bouchet - Ghania Bouzemame
 * @version 3.0
 *
 */
@ManagedBean
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	private long idAgence;
	@Column(nullable=false)
	private String lastName;
	@Column(nullable=false)
	private String firstName;

	public Actor() {
		super();

	}

	public Actor(long idAgence, String lastName, String firstName) {
		super();
		this.idAgence = idAgence;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	

	

	public Actor(String lastName, String firstName) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public long getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(long idAgence) {
		this.idAgence = idAgence;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
