package org.formation.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.formation.beans.Client;
import org.formation.service.IServiceClient;
import org.formation.service.ServiceClient;

@ManagedBean
@SessionScoped
public class ClientController  {  //implements Serializable

	private static final long serialVersionUID = 1L;

//	@Inject
//	IServiceClient serviceClient;
	
	IServiceClient serviceClient = new ServiceClient();

	private List<Client> clients = new ArrayList<>();
	Client client = new Client();

	public ClientController() {
		super();
	}

	public ClientController(List<Client> clients) {
		super();
		this.clients = clients;
	}

	public String createClient(Client client) {

		try {

			serviceClient.createClient(client);

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return "listClients.xhtml";
	}

	public String updateClient(Client client) {

		try {

			serviceClient.updateClient(client);

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return "listClients.xhtml";
	}

	public Client readClient(long idClient) {

		Client client = new Client();
		try {
			client = serviceClient.readClient(idClient);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	}

	public void loadClients() {
		
		clients.clear();

		try {

			clients = serviceClient.readList();

		} catch (Exception e) {
			e.getMessage();

		} finally {

		}
	}

	public String deleteClient(long idClient) {
		try {
			serviceClient.deleteClient(idClient);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} finally {

		}
		return "";

	}

	public List<Client> getClients() {
		return clients;
	}

	public String loadClient(int idClient) {
		
		try {

			Client client = serviceClient.readClient(idClient);

			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("client", client);

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

		return "update.xhtml";
	}

}
