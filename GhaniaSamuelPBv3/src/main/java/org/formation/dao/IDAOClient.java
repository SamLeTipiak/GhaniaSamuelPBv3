package org.formation.dao;

import java.sql.SQLException;
import java.util.List;

import org.formation.beans.Client;

public interface IDAOClient {
	
	public void createClient(Client client) throws SQLException;
	
	public void updateClient(Client client) throws SQLException;
	
	public Client readClient(long idClient) throws SQLException;
	
	public List<Client> readList() throws SQLException;
	
	public void deleteClient(long idClient) throws SQLException;

}
