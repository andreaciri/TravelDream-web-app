package it.polimi.TravelDream.ejb.entities;

import it.polimi.TravelDream.ejb.entities.Component;

import java.io.Serializable;
import java.lang.String;
import java.sql.Timestamp;

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

	
	@Column(nullable=false)
	private int idComponent;
	
	@Column(nullable=false)
	private String place;
	
	@Column(nullable=false)
	private Timestamp start;
	
	@Column(nullable=false)
	private Timestamp finish;
	private static final long serialVersionUID = 1L;

	public Excursion() {
		super();
	}   
	
	public Excursion(String name, String description, int price, int idComponent, String idType) {
		super(name, description, price, idComponent, idType);
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
	public Timestamp getStart() {
		return this.start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}   
	public Timestamp getFinish() {
		return this.finish;
	}

	public void setFinish(Timestamp finish) {
		this.finish = finish;
	}
   
}
