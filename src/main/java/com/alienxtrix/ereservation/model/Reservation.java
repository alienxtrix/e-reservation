/**
 * 
 */
package com.alienxtrix.ereservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Class represents reservation table
 * 
 * @author Josh Fuentes
 *
 */
@Data
@Entity
@Table(name = "reservation")
public class Reservation {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idReservation;
	@Temporal(TemporalType.DATE)
	private Date dateStart;
	@Temporal(TemporalType.DATE)
	private Date dateEnd;
	private int quantityPersons;
	private String description;
	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;

}
