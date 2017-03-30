package org.formation.service;

import java.util.List;

import org.formation.beans.Client;

public interface IServiceClient {
	
public void createClient(Client client) throws Exception;
	
	public void updateClient(Client client) throws Exception;
	
	public Client readClient(long idClient) throws Exception;
	
	public List<Client> readList() throws Exception;
	
	public void deleteClient(long idClient) throws Exception;

}
