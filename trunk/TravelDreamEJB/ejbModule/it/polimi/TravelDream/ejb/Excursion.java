package it.polimi.TravelDream.ejb;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Excursion
 *
 */
@Entity

public class Excursion implements Serializable {

	   
	@Id
	private int idComponent;
	private static final long serialVersionUID = 1L;

	public Excursion() {
		super();
	}   
	public int getIdComponent() {
		return this.idComponent;
	}

	public void setIdComponent(int idComponent) {
		this.idComponent = idComponent;
	}
   
}
