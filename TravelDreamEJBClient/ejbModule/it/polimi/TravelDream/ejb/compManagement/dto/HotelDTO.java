package it.polimi.TravelDream.ejb.compManagement.dto;

import java.util.Date;

public class HotelDTO extends ComponentDTO {

	private String place;
	private Date checkin;
	private Date checkout;

	public HotelDTO (String title, String description, Integer price){
		this.title = title;
		this.description = description;
		this.price = price;
		
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
