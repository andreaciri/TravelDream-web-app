package it.polimi.TravelDream.ejb.entities;

import it.polimi.TravelDream.ejb.entities.Component;

import java.io.Serializable;
import java.sql.Date;

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
	
	private String departurePlace;
	private String arrivalPlace;
	private Date departureDate;
	private Date returnDate;

	public Flight() {
		super();
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

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return returnDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.returnDate = arrivalDate;
	}
   
}
