package org.formation.service;

import java.util.List;

import javax.inject.Inject;

import org.formation.beans.Client;
import org.formation.dao.DAOClient;
import org.formation.dao.IDAOClient;

/**
 * <b>ServiceClient implémente l'interface IServiceClient et contient les méthodes qui vont permettre d'appeler celles de la partie DAO qui concerne les clients de la banque.</b>
 * <p>Ici sont donc définies les méthodes propres à la partie Service et relatives aux actions sur le client.</p>
 * @author Samuel Bouchet - Ghania Bouzemame
 *@version 3.0
 */
public class ServiceClient implements IServiceClient {

//	@Inject
//	IDAOClient daoClient;
	
	IDAOClient daoClient = new DAOClient();

	/* (non-Javadoc)
	 * @see org.formation.service.IServiceClient#createClient(org.formation.beans.Client)
	 */
	@Override
	public void createClient(Client client) throws Exception {

		daoClient.createClient(client);

	}

	/* (non-Javadoc)
	 * @see org.formation.service.IServiceClient#updateClient(org.formation.beans.Client)
	 */
	@Override
	public void updateClient(Client client) throws Exception {

		daoClient.updateClient(client);

	}

	/* (non-Javadoc)
	 * @see org.formation.service.IServiceClient#readClient(long)
	 */
	@Override
	public Client readClient(long idClient) throws Exception {

		Client client = daoClient.readClient(idClient);
		return client;
	}

	/* (non-Javadoc)
	 * @see org.formation.service.IServiceClient#readList()
	 */
	@Override
	public List<Client> readList() throws Exception {
		List<Client> clients = daoClient.readList();
		return clients;
	}

	/* (non-Javadoc)
	 * @see org.formation.service.IServiceClient#deleteClient(long)
	 */
	@Override
	public void deleteClient(long idClient) throws Exception {

		daoClient.deleteClient(idClient);

	}

}
