package it.polimi.TravelDream.ejb;

import it.polimi.TravelDream.ejb.Component;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Excursion
 *
 */
@Entity
@Table(name="EXCURSION")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Excursion extends Component implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Excursion() {
		super();
	}
   
}
