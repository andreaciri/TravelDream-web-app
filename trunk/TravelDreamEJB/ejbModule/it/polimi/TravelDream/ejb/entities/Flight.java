package it.polimi.TravelDream.ejb.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Flight
 *
 */
@Entity
@Table(name="FLIGHT")
public class Flight implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private int idComponent;
	
	public Flight() {
		super();
	}
   
}
