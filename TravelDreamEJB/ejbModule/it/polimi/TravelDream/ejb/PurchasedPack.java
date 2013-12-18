package it.polimi.TravelDream.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PURCHASED_PACK database table.
 * 
 */
@Entity
@Table(name="PURCHASED_PACK")
@NamedQuery(name="PurchasedPack.findAll", query="SELECT p FROM PurchasedPack p")
public class PurchasedPack implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idBooking;

	private int guests;

	private int idPackage;

	private int totalPrice;

	private String username;

	public PurchasedPack() {
	}

	public int getIdBooking() {
		return this.idBooking;
	}

	public void setIdBooking(int idBooking) {
		this.idBooking = idBooking;
	}

	public int getGuests() {
		return this.guests;
	}

	public void setGuests(int guests) {
		this.guests = guests;
	}

	public int getIdPackage() {
		return this.idPackage;
	}

	public void setIdPackage(int idPackage) {
		this.idPackage = idPackage;
	}

	public int getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}