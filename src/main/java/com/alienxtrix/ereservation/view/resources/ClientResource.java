/**
 * 
 */
package com.alienxtrix.ereservation.view.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alienxtrix.ereservation.bussiness.service.ClientService;
import com.alienxtrix.ereservation.model.Client;
import com.alienxtrix.ereservation.view.resources.vo.ClientVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Class represents the web service client
 * 
 * @author Josh Fuentes
 *
 */
@RestController
@RequestMapping("/api/client")
@Api(tags = "client")
public class ClientResource {

	private final ClientService clientService;

	public ClientResource(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping
	@ApiOperation(value = "Create client", notes = "Service to create a new client")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "client created successfully"),
			@ApiResponse(code = 400, message = "Response invalid")})
	public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVo) {
		Client client = new Client();
		client.setClientName(clientVo.getClientName());
		client.setClientLastName(clientVo.getClientLastName());
		client.setClientAddress(clientVo.getClientAddress());
		client.setClientPhone(clientVo.getClientPhone());
		client.setClientMail(clientVo.getClientMail());

		return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);

	}

	@PutMapping("/{key}")
	@ApiOperation(value = "Update client", notes = "Service to update a client")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "client updated successfully"),
			@ApiResponse(code = 404, message = "Client non founded")})
	public ResponseEntity<Client> updateClient(@PathVariable("key") String key, ClientVO clientVo) {
		Client client = this.clientService.findByClientKey(key);
		if (client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		} else {
			client.setClientName(clientVo.getClientName());
			client.setClientLastName(clientVo.getClientLastName());
			client.setClientAddress(clientVo.getClientAddress());
			client.setClientPhone(clientVo.getClientPhone());
			client.setClientMail(clientVo.getClientMail());
		}
		return new ResponseEntity<>(this.clientService.update(client), HttpStatus.OK);
	}

	@DeleteMapping("/{key}")
	@ApiOperation(value = "Delete client", notes = "Service to delete a client")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "client Deleted successfully"),
			@ApiResponse(code = 404, message = "Client non founded")})
	public void deleteClient(@PathVariable("key") String key) {
		Client client = this.clientService.findByClientKey(key);
		if (client != null) {
			this.clientService.delete(client);
		}
	}
	@GetMapping
	@ApiOperation(value = "List clients", notes = "Service to list all clients")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Clients fouded"),
			@ApiResponse(code = 404, message = "Clients non founded")})
	public ResponseEntity<List<Client>> findAll(){
		return ResponseEntity.ok(this.clientService.findAll());
		
		
	}
}
