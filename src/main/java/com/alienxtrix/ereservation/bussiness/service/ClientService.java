/**
 * 
 */
package com.alienxtrix.ereservation.bussiness.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alienxtrix.ereservation.bussiness.repository.ClientRepository;
import com.alienxtrix.ereservation.model.Client;

/**
 * Class to define the client services
 * 
 * @author Josh Fuentes
 *
 */
@Service
@Transactional(readOnly = true)
public class ClientService {
	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	/**
	 * Method to realize the save operation for clients
	 * 
	 * @param client
	 * @return
	 */
	@Transactional
	public Client create(Client client) {
		return this.clientRepository.save(client);
	}

	/**
	 * Method to realize the update operation for clients
	 * 
	 * @param client
	 * @return
	 */
	@Transactional
	public Client update(Client client) {
		return this.clientRepository.save(client);
	}

	/**
	 * Method to realize the delete operation for clients
	 * 
	 * @param client
	 * @return
	 */
	@Transactional
	public void delete(Client client) {
		this.clientRepository.delete(client);
	}

	/**
	 * Method to consult a client by the Key
	 * 
	 * @param clientKey
	 * @return
	 */
	public Client findByClientKey(String clientKey) {
		return this.clientRepository.findByClientKey(clientKey);
	}
	
	public List<Client> findAll(){
		return this.clientRepository.findAll();		
	}

}
