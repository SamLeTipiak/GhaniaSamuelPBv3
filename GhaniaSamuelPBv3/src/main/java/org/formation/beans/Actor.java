package org.formation.beans;

public class Actor {
	
	private long idAgence;
	private String lastName;
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

	
	
}
