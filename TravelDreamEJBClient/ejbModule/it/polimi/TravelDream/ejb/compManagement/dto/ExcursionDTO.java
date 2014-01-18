package it.polimi.TravelDream.ejb.compManagement.dto;

import java.util.Date;

public class ExcursionDTO extends ComponentDTO {

	private String place;
	private Date start;
	private Date finish;
	
	public ExcursionDTO (String title, String description, Integer price){
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
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getFinish() {
		return finish;
	}
	public void setFinish(Date finish) {
		this.finish = finish;
	}
	
	
}
