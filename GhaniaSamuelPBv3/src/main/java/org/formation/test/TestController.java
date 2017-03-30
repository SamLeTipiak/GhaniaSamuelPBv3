package org.formation.test;

import java.util.ArrayList;
import java.util.List;

import org.formation.beans.Client;
import org.formation.presentation.ClientController;

public class TestController {

	public static void main(String[] args) {
		List<Client> clients = new ArrayList<>();
		ClientController clientController = new ClientController(clients);
		
		clientController.loadClients();
		System.out.println("coucou");
		System.out.println(clientController.readList().size());
	
		
		System.out.println(clientController.readClient(3));

	}

}
