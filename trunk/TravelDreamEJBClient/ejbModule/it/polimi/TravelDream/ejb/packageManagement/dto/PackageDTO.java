package it.polimi.TravelDream.ejb.packageManagement.dto;


public class PackageDTO {
	
	private int idPackage;

	private String description;
	
	private String title;

	private String type;
	
	public PackageDTO(){
	}
	
	public int getIdPackage() {
		return idPackage;
	}
	
	public void setIdPackage(int idPackage) {
		this.idPackage = idPackage;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
}

	
	
     
  
