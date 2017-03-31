package org.formation.service;

import java.util.List;

import org.formation.beans.Client;

/**
 *Sont déclarées dans cette interface toutes les méthodes propres à la partie Service et relatives aux actions clients. Elles sont définies dans la classe {@link ServiceClient}.
 *@see ServiceClient#createClient(Client)
 *@see ServiceClient#updateClient(Client)
 *@see ServiceClient#readClient(long)
 *@see ServiceClient#readList()
 *@see ServiceClient#deleteClient(long)
 * @author Samuel Bouchet - Ghania Bouzemame
 * @version 3.0
 *
 */
public interface IServiceClient {
	
public void createClient(Client client) throws Exception;
	
	public void updateClient(Client client) throws Exception;
	
	public Client readClient(long idClient) throws Exception;
	
	public List<Client> readList() throws Exception;
	
	public void deleteClient(long idClient) throws Exception;

}
