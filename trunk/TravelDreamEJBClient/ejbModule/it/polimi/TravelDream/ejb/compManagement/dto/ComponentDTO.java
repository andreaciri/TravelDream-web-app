package it.polimi.TravelDream.ejb.compManagement.dto;

import it.polimi.TravelDream.ejb.packageManagement.dto.PackageDTO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class ComponentDTO {

	//declared protected, so subclasses can inherit them
	@NotEmpty
	protected String title;
	protected String description;
	protected Integer price;
	protected int idComponent;
	
	public ComponentDTO(){
	}
	
	public String infoToString () {
		return "generic Component";
	}
	
	public String typeToString() {
		String type = this.getClass().getSimpleName();
		return type.substring(0, (type.length()-3));
	}
	
	protected String dateToString(java.util.Date date){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return df.format(date);
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

	public int getIdComponent() {
		return idComponent;
	}

	public void setIdComponent(int idComponent) {
		this.idComponent = idComponent;
	}

//	public List<PackageDTO> getCriticalPacks() {
//		return criticalPacks;
//	}
//
//	public void setCriticalPacks(List<PackageDTO> criticalPacks) {
//		this.criticalPacks = criticalPacks;
//	}
//	
//	public String criticalPacksToString() {
//		StringBuilder sb = new StringBuilder();
//		for (PackageDTO p : criticalPacks){
//			sb.append(p.getType()+" package: "+p.getTitle()+", id: "+p.getIdPackage());
//		}
//		return sb.toString();
//	}
}
