package it.polimi.TravelDream.ejb.packageManagement.dto;

import java.util.ArrayList;
import java.util.List;

import it.polimi.TravelDream.ejb.compManagement.dto.*;


public class PackageDTO {
	
	private int idPackage;

	private String description;
	
	private String title;

	private String type;
	
	private List<ComponentDTO> components;
	
	public PackageDTO(){
		components=new ArrayList<ComponentDTO>();
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

	public List<ComponentDTO> getComponents() {
		return components;
	}

	public void setComponents(List<ComponentDTO> components) {
		this.components = components;
	}
	
	public void addComponent(ComponentDTO c){
		components.add(c);
	}
}

	
	
     
  
