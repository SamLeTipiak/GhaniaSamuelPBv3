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

@ManagedBean
@Entity
public class Agence {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idAgence;
	private String creationDate;
	@OneToMany(mappedBy="agence", cascade=CascadeType.ALL)
	private List<Adviser> Advisers = new ArrayList<>();
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
		return Advisers;
	}
	public void setAdvisers(List<Adviser> advisers) {
		Advisers = advisers;
	}
	public Set<Client> getClients() {
		return clients;
	}
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	@Override
	public String toString() {
		return "Agence [idAgence=" + idAgence + ", creationDate=" + creationDate + "]";
	}
	
	

}
