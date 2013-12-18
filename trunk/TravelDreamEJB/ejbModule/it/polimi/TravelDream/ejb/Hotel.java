package it.polimi.TravelDream.ejb;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Hotel
 *
 */
@Entity

public class Hotel implements Serializable {

	   
	@Id
	private int idComponent;
	private static final long serialVersionUID = 1L;

	public Hotel() {
		super();
	}   
	public int getIdComponent() {
		return this.idComponent;
	}

	public void setIdComponent(int idComponent) {
		this.idComponent = idComponent;
	}
   
}
