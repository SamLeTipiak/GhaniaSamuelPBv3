package org.formation.dao;

import java.sql.SQLException;
import java.util.List;

import org.formation.beans.Client;

/**
 * Sont déclarées dans cette interface toutes les méthodes propres à la partie DAO et qui sont relatives aux clients . Elles sont définies dans la classe {@link DAOClient}.
 * @see DAOClient#createClient(Client)
 * @see DAOClient#updateClient(Client)
 * @see DAOClient#readClient(long)
 * @see DAOClient#readList()
 * @see DAOClient#deleteClient(long)
 * @author Samuel Bouchet - Ghania Bouzemame
 *@version 3.0
 */
public interface IDAOClient {
	
	public void createClient(Client client) throws SQLException;
	
	public void updateClient(Client client) throws SQLException;
	
	public Client readClient(long idClient) throws SQLException;
	
	public List<Client> readList() throws SQLException;
	
	public void deleteClient(long idClient) throws SQLException;

}
