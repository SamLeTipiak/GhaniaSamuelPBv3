package org.formation.dao;

import java.sql.SQLException;

import org.formation.beans.Client;

public class TestCreationDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IDAOClient dao = new DAOClient();
		
		Client client1 = new Client("Cocu", "hugu", "45 rue bellu", 45645, "Parus", "01014578996");
		Client client2 = new Client("Coco", "hugo", "45 rue bello", 45645, "Paros", "01024578996");
		Client client3 = new Client("Coca", "hugu", "45 rue bella", 45645, "Paras", "01034578996");
		Client client4 = new Client("Coci", "hugi", "45 rue belli", 45645, "Paris", "01044578996");
		
		try {
			dao.createClient(client1);
			dao.createClient(client2);
			dao.createClient(client3);
			dao.createClient(client4);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
