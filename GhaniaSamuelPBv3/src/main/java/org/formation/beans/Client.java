package org.formation.beans;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Client
 * 
 * @author Bouchet Samuel - Ghania Bouzemame
 * @version 3.0
 *
 */

@ManagedBean
@Entity
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idClient;
	private String lastName;
	private String firstName;
	private String address;
	private int zipCode;
	private String city;
	private String phoneNumer;

	public Client() {
		super();
	}

	public Client(String lastName, String firstName, String address, int zipCode, String city, String phoneNumer) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.phoneNumer = phoneNumer;
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

	@Override
	public String toString() {
		return "Client [lastName=" + lastName + ", firstName=" + firstName + ", address=" + address + ", zipCode="
				+ zipCode + ", city=" + city + ", phoneNumer=" + phoneNumer + "]";
	}

}
