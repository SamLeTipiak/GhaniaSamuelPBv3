package org.formation.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.formation.beans.Client;
import org.formation.service.IServiceClient;
import org.formation.service.ServiceClient;

@ManagedBean
@SessionScoped
public class ClientController implements Serializable {

	private static final long serialVersionUID = 1L;

	IServiceClient serviceClient = new ServiceClient();

	private List<Client> clients = new ArrayList<>();
	Client client = new Client();

	public ClientController() {
		super();
	}

	public ClientController(List<Client> clients) {
		super();
		this.clients = clients;
	}

	public void createClient(Client client) {

		try {

			serviceClient.createClient(client);

		} catch (Exception e) {

		}

	}

	public void updateClient(Client client) {

		try {

			serviceClient.updateClient(client);

		} catch (Exception e) {

		}

	}

	public Client readClient(long idClient) {
		
		Client client = new Client();
		try {
			client =  serviceClient.readClient(idClient);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	}

	public List<Client> readList() {
		return clients;
	}

	public void loadClients() {
		clients.clear();

		try {
			clients = serviceClient.readList();

		} catch (Exception e) {
			e.getMessage();

		} finally {

		}
	}

	public void deleteClient(long idClient) {
		try {
			serviceClient.deleteClient(idClient);
		} catch (Exception e) {
		} finally {

		}

	}

}
