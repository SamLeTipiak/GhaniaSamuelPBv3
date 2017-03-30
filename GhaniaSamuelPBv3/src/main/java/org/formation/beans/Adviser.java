package org.formation.beans;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ManagedBean
@Entity
public class Adviser extends Actor{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idAdviser;

	
	
}
