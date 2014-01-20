package it.polimi.TravelDream.ejb.compManagement.dto;

import java.util.Date;

public class ExcursionDTO extends ComponentDTO {

	private String place;
	private Date start;
	private Date finish;
	
	public ExcursionDTO (String title, String description, Integer price, int id){
		this.title = title;
		this.description = description;
		this.price = price;
		this.idComponent = id;
		
	}
	
	@Override
	public String infoToString () {
		return place+" - from "+start.toString()+" to "+finish.toString();
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
