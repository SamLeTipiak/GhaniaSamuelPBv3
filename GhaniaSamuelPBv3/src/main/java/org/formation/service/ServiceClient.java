package org.formation.service;

import java.util.List;



import org.formation.beans.Client;
import org.formation.dao.DAOClient;
import org.formation.dao.IDAOClient;

public class ServiceClient implements IServiceClient {

//	@Inject
	private IDAOClient daoClient = new DAOClient();

	@Override
	public void createClient(Client client) throws Exception {

		daoClient.createClient(client);

	}

	@Override
	public void updateClient(Client client) throws Exception {

		daoClient.updateClient(client);

	}

	@Override
	public Client readClient(long idClient) throws Exception {

		Client client = daoClient.readClient(idClient);
		return client;
	}

	@Override
	public List<Client> readList() throws Exception {

		List<Client> clients = daoClient.readList();
		return clients;
	}

	@Override
	public void deleteClient(long idClient) throws Exception {

		daoClient.deleteClient(idClient);

	}

}
