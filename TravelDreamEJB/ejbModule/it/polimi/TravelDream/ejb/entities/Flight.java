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
	
	@Column(nullable=false)
	private String departurePlace;
	
	@Column(nullable=false)
	private String arrivalPlace;
	
	@Column(nullable=false)
	private Date departureDate;
	
	@Column(nullable=false)
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

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date arrivalDate) {
		this.returnDate = arrivalDate;
	}
   
}
