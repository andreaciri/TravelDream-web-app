package it.polimi.TravelDream.ejb.compManagement.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class ComponentDTO {

	//declared protected, so subclasses can inherit them
	@NotEmpty
	protected String title;
	protected String description;
	protected Integer price;
	
	public ComponentDTO(){
		
	}
	
	public String infoToString () {
		return "generic Component";
	}
	
	public String typeToString() {
		String type = this.getClass().getSimpleName();
		return type.substring(0, (type.length()-3));
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
}
