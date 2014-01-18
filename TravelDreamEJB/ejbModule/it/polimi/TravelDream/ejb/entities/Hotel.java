package it.polimi.TravelDream.ejb.entities;

import it.polimi.TravelDream.ejb.entities.Component;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Hotel
 *
 */
@Entity
@Table(name="HOTEL")
@DiscriminatorValue("HTL")
@Inheritance(strategy=InheritanceType.JOINED)
public class Hotel extends Component implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Hotel() {
		super();
	}
   
}
