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
 * 
 * @author Josh Fuentes
 *
 */
@Data
@Entity
@Table(name = "client")
@NamedQuery(name = "Client.findByClientKey", query = "Select c from Client c where c.clientKey = ?1")
public class Client {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idClient;
	private String clientName;
	private String clientLastName;
	private String clientKey;
	private String clientAddress;
	private String clientPhone;
	private String clientMail;
	@OneToMany(mappedBy = "client")
	private java.util.Set<Reservation> reservation;

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientLastName() {
		return clientLastName;
	}

	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
	}

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getClientMail() {
		return clientMail;
	}

	public void setClientMail(String clientMail) {
		this.clientMail = clientMail;
	}

	public java.util.Set<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(java.util.Set<Reservation> reservation) {
		this.reservation = reservation;
	}
	

}
