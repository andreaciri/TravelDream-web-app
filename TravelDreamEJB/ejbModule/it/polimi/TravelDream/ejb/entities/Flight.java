package it.polimi.TravelDream.ejb.entities;

import it.polimi.TravelDream.ejb.entities.Component;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Flight
 *
 */
@Entity
@Table(name="FLIGHT")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Flight extends Component implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Flight() {
		super();
	}
   
}
