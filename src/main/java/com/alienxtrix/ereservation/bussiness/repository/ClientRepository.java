/**
 * 
 */
package com.alienxtrix.ereservation.bussiness.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alienxtrix.ereservation.model.Client;

/**
 * Interface for define database operations related with the client
 * @author Josh Fuentes
 *
 */
public interface ClientRepository extends JpaRepository<Client, String>{
	/**
	 * Method definition to search client by lastname
	 * @param clientLastName
	 * @return
	 */
	public List<Client> findByClientLastName(String clientLastName);
	
	public Client findByClientKey(String clientKey);
	
	
	
	
	

}
