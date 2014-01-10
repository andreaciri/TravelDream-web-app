package it.polimi.TravelDream.ejb.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Hotel
 *
 */
@Entity
@Table(name="FLIGHT")
public class Hotel implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private int idComponent;
	
	public Hotel() {
		super();
	}
   
}
