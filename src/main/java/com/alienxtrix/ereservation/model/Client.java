/**
 * 
 */
package com.alienxtrix.ereservation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.mapping.Set;

import lombok.Data;

/**
 * Class represents client table
 * @author Josh Fuentes
 *
 */
@Data
@Entity
@Table(name = "client")
@NamedQuery(name = "Client.findByClientKey", query="Select c from client c where c.clientKey = ?1")
public class Client {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String idclient;
	private String clientName;
	private String clientLastName;
	private String clientKey;
	private String clientAddress;
	private String clientPhone;
	private String clientMail;
	@OneToMany(mappedBy="client")
	private java.util.Set<Reservation> reservation;
	
	

}
