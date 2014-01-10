package it.polimi.TravelDream.ejb.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Excursion
 *
 */
@Entity
@Table(name="EXCURSION")
public class Excursion implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private int idComponent;
	
	public Excursion() {
		super();
	}
   
}
