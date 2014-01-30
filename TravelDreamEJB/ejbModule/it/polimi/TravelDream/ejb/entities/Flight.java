package it.polimi.TravelDream.ejb.entities;

import it.polimi.TravelDream.ejb.entities.Component;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Flight
 *
 */
@Entity
@Table(name="FLIGHT")
@DiscriminatorValue("FLG")
@Inheritance(strategy=InheritanceType.JOINED)
public class Flight extends Component implements Serializable {

	

	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false)
	private String departurePlace;
	
	@Column(nullable=false)
	private String arrivalPlace;
	
	@Column(nullable=false)
	private Timestamp departureDate;
	
	@Column(nullable=false)
	private Timestamp returnDate;

	public Flight() {
		super();
	}

	public Flight(String name, String description, int price, int idComponent, String idType) {
		super(name, description, price, idComponent, idType);
	}

	public String getArrivalPlace() {
		return arrivalPlace;
	}

	public void setArrivalPlace(String arrivalPlace) {
		this.arrivalPlace = arrivalPlace;
	}

	public String getDeparturePlace() {
		return departurePlace;
	}

	public void setDeparturePlace(String departurePlace) {
		this.departurePlace = departurePlace;
	}

	public Timestamp getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Timestamp departureDate) {
		this.departureDate = departureDate;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Timestamp arrivalDate) {
		this.returnDate = arrivalDate;
	}
   
}
