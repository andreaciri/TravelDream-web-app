package it.polimi.TravelDream.ejb.entities;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBooking;

	private int guests;

	@ManyToOne
	@JoinColumn(name="idPackage")
	private Package purchasedPack;
	
	@ManyToOne
	@JoinColumn(name="username")
	private User user;

	private int totalPrice;


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

	public int getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Package getPurchasedPack() {
		return purchasedPack;
	}

	public void setPurchasedPack(Package purchasedPack) {
		this.purchasedPack = purchasedPack;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}