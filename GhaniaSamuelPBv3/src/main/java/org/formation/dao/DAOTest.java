package org.formation.dao;

import java.sql.SQLException;
import java.util.List;

import org.formation.beans.Client;

public class DAOTest {

	public static void main(String[] args) {
		
		IDAOClient dao = new DAOClient();
//		
//		Client client1 = new Client("Coco", "hugo", "45 rue belle", 45645, "paris", "124578996");
//		Client c2 = new Client("nom", "prenom",new Account(5644, 565.56, "jsf"));
		
		
		System.out.println("avant le try");
		try {
			List<Client> listeCl1 = dao.readList();
			
			System.out.println("après le listeCl1");	
			
			System.out.println("le client number one : " + listeCl1.get(0));
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
