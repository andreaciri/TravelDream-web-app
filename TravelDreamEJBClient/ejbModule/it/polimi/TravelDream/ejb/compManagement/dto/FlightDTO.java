package it.polimi.TravelDream.ejb.compManagement.dto;

import java.util.Date;

public class FlightDTO extends ComponentDTO {
	private String departurePlace;
	private String arrivalPlace;
	private Date departureDate;
	private Date returnDate;
	
	
	public FlightDTO (String title, String description, Integer price, Integer id){
		this.title = title;
		this.description = description;
		this.price = price;
		this.idComponent = id;
		
	}
	
	@Override
	public String infoToString () {
		return departurePlace+", "+departureDate.toString()+" - "+arrivalPlace+", "+returnDate.toString();
	}
	
	public String getDeparturePlace() {
		return departurePlace;
	}
	public void setDeparturePlace(String departurePlace) {
		this.departurePlace = departurePlace;
	}
	public String getArrivalPlace() {
		return arrivalPlace;
	}
	public void setArrivalPlace(String arrivalPlace) {
		this.arrivalPlace = arrivalPlace;
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
