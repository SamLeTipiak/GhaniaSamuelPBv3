package org.formation.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.formation.beans.Client;
import org.formation.dao.DAOClient;
import org.formation.dao.IDAOClient;
import org.formation.presentation.ClientController;

public class TestController {

	public static void main(String[] args) {
		List<Client> clients = new ArrayList<>();
		IDAOClient daoc = new DAOClient();
		Client client = new Client("ae", "ba", "ce", 4, "de", "5");

		try {
//			daoc.createClient(client);
			 daoc.updateClient(client);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
