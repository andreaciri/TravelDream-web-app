package it.polimi.TravelDream.authentication.web.beans;

import it.polimi.TravelDream.ejb.compManagement.CompMgrInterface;
import it.polimi.TravelDream.ejb.compManagement.dto.*;
import it.polimi.TravelDream.enumeration.City;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
	private String holidayPlace;
	
//	component that will be created
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
		title = "component title";
		description = "";
		price = 40;
		holidayPlace = City.randomCity().toString();
		
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
	
	
	
	//called when the selected type of component change (dropdown menu)
	public void handleTypeChange() {
		System.out.println("variabile type:"+type);
		Date now = new Date();

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
			((FlightDTO) newComponent).setDeparturePlace("Milan");
			((FlightDTO) newComponent).setArrivalPlace(holidayPlace);
			((FlightDTO) newComponent).setDepartureDate(addDays(now, 7));
			((FlightDTO) newComponent).setReturnDate(addDays(now, 14));
			
			
			break;
			
		case "Hotel":
			basicRend=true;
			flightRend=false;
			hotelRend=true;
			excursionRend=false;
			
			newComponent = new HotelDTO(title, description, price);
			((HotelDTO) newComponent).setPlace(holidayPlace);
			((HotelDTO) newComponent).setCheckin(addDays(now, 7));
			((HotelDTO) newComponent).setCheckout(addDays(now, 14));
			
			break;
			
		case "Excursion":
			basicRend=true;
			flightRend=false;
			hotelRend=false;
			excursionRend=true;
			
			newComponent = new ExcursionDTO(title, description, price);
			((ExcursionDTO) newComponent).setPlace(holidayPlace);
			((ExcursionDTO) newComponent).setStart(addDays(now, 8));
			((ExcursionDTO) newComponent).setFinish(addDays(now, 11));
			
			break;
		
		}
		
	}

	//add days to the variable date
	private Date addDays(Date date, int days){
		Calendar cal = Calendar.getInstance();  
		cal.setTime(date);  
		cal.add(Calendar.DATE, days); //add days
		  
		date = cal.getTime();
		return date;
	}
	
	/* --- GETTER AND SETTER METHODS --- */
	
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
