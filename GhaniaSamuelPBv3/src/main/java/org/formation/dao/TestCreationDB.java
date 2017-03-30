package org.formation.dao;

import java.sql.SQLException;

import org.formation.beans.Client;

public class TestCreationDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IDAOClient dao = new DAOClient();
		
		Client client1 = new Client("Coco", "hugo", "45 rue belle", 45645, "paris", "124578996");
		
		try {
			dao.createClient(client1);
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
