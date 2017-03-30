package org.formation.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.formation.beans.Client;
import org.formation.service.IServiceClient;

public class ClientController {

	@Inject
	IServiceClient serviceClient;
	private List<Client> clients = new ArrayList<>();
	Client client = new Client();

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
