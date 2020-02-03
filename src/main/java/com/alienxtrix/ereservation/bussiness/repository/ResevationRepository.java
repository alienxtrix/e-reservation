/**
 * 
 */
package com.alienxtrix.ereservation.bussiness.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alienxtrix.ereservation.model.Reservation;

/**
 * Interface for define database operations related with the reservation
 * @author Josh Fuentes
 *
 */
public interface ResevationRepository extends JpaRepository<Reservation, String> {
	
	@Query("Select r from reservation r where r.dateStart =:dateStartRes and r.dateEnd =:dateEndRes")
	public List<Reservation> find(@Param("dateStartRes") Date dateStartRes, @Param("dateEndRes") Date dateEndRes);
	
	

}
