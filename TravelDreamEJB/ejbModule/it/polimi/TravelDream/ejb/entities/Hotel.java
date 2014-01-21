package it.polimi.TravelDream.ejb.entities;

import it.polimi.TravelDream.ejb.entities.Component;

import java.io.Serializable;
import java.sql.Date;

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

	@Column(nullable=false)
	private String place;
	
	@Column(nullable=false)
	private Date checkin;
	
	@Column(nullable=false)
	private Date checkout;
	
	public Hotel() {
		super();
	}
	
	public Hotel(String name, String description, int price, int idComponent, String idType) {
		super(name, description, price, idComponent, idType);
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

   
}
