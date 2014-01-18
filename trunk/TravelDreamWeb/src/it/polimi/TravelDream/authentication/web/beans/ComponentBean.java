package it.polimi.TravelDream.authentication.web.beans;

import it.polimi.TravelDream.ejb.compManagement.CompMgrInterface;
import it.polimi.TravelDream.ejb.compManagement.dto.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

@ManagedBean(name="componentBean")
@ViewScoped
public class ComponentBean implements Serializable{
	
	@EJB
	private CompMgrInterface compMgr;
	
	public List<String> types = new ArrayList<String>();
	public String type;
	
//	component the will be created
	public ComponentDTO newComponent;
	
//	temp variables that keep basic info
	private String title;
	private String description;
	private Integer price;
	
//	variables that can rendering or not some input form
	private Boolean basicRend;
	private Boolean flightRend;
	private Boolean hotelRend;
	private Boolean excursionRend; 
	
	public ComponentBean(){
		
		basicRend=false;
		flightRend=false;
		hotelRend=false;
		excursionRend=false;
		
		type = "null";
		title = "";
		description = "";
		price = 40;
		
		types.add("Flight");
		types.add("Hotel");
		types.add("Excursion");
			
		}
	
	public void createComp() {
		if(type.equals("null")){
			System.out.println("type = "+type);
			return;
		}
		System.out.println("componentBean - creazione ");
		compMgr.save(newComponent);
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("createDialog.show();");
	}
	
	public void handleTypeChange() {
		System.out.println("variabile type:"+type);
		switch (type) {
		
		case "null":
			basicRend=false;
			flightRend=false;
			hotelRend=false;
			excursionRend=false; 
			break;
			
		case "Flight":
			basicRend=true;
			flightRend=true;
			hotelRend=false;
			excursionRend=false;
			
			newComponent = new FlightDTO(title, description, price);
			
			break;
			
		case "Hotel":
			basicRend=true;
			flightRend=false;
			hotelRend=true;
			excursionRend=false;
			break;
			
		case "Excursion":
			basicRend=true;
			flightRend=false;
			hotelRend=false;
			excursionRend=true;
			break;
		
		}
		
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Boolean getFlightRend() {
		return flightRend;
	}

	public void setFlightRend(Boolean flightRend) {
		this.flightRend = flightRend;
	}

	public Boolean getHotelRend() {
		return hotelRend;
	}

	public void setHotelRend(Boolean hotelRend) {
		this.hotelRend = hotelRend;
	}

	public Boolean getExcursionRend() {
		return excursionRend;
	}

	public void setExcursionRend(Boolean excursionRend) {
		this.excursionRend = excursionRend;
	}

	public Boolean getBasicRend() {
		return basicRend;
	}

	public void setBasicRend(Boolean basicRend) {
		this.basicRend = basicRend;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public ComponentDTO getNewComponent() {
		return newComponent;
	}

	public void setNewComponent(ComponentDTO newComponent) {
		this.newComponent = newComponent;
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
