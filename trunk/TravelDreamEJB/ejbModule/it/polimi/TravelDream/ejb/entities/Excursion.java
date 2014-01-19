package it.polimi.TravelDream.ejb.entities;

import it.polimi.TravelDream.ejb.entities.Component;
import java.io.Serializable;
import java.lang.String;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Excursion
 *
 */
@Entity
@Table(name="EXCURSION")
@DiscriminatorValue("XCR")
@Inheritance(strategy=InheritanceType.JOINED)
public class Excursion extends Component implements Serializable {

	   
	private int idComponent;
	private String place;
	private Date start;
	private Date finish;
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
 
	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}   
	public Date getStart() {
		return this.start;
	}

	public void setStart(Date start) {
		this.start = start;
	}   
	public Date getFinish() {
		return this.finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}
   
}
