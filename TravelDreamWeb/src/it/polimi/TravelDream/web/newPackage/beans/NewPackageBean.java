package it.polimi.TravelDream.web.newPackage.beans;

import it.polimi.TravelDream.ejb.compManagement.CompMgrInterface;
import it.polimi.TravelDream.ejb.compManagement.dto.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="newPackage")
@ViewScoped
public class NewPackageBean implements Serializable{

	@EJB
	private CompMgrInterface compMgr;
	
	private List<FlightDTO> flights;
	private List<HotelDTO> hotels;
	private List<ExcursionDTO> excursions;
	//selected non puo' essere una lista per dataTable con selezione singola
	private FlightDTO selected;			
	
	public NewPackageBean(){
	}
	
	@PostConstruct
	public void afterConstruct() {
		flights = compMgr.getAllFlightsDTO();
		hotels = compMgr.getAllHotelsDTO();
		excursions = compMgr.getAllExcsDTO();
		
	}
	
	public void newPackPreRender(){
		//ATTENZIONE PUO PARTIRE AD OGNI UPDATE AJAX - RISOLVERE
	}
	
	public List<FlightDTO> getFlights() {
		return flights;
	}
	public void setFlights(List<FlightDTO> flights) {
		this.flights = flights;
	}
	public List<HotelDTO> getHotels() {
		return hotels;
	}
	public void setHotels(List<HotelDTO> hotels) {
		this.hotels = hotels;
	}
	public List<ExcursionDTO> getExcursions() {
		return excursions;
	}
	public void setExcursions(List<ExcursionDTO> excursions) {
		this.excursions = excursions;
	}

	public FlightDTO getSelected() {
		return selected;
	}

	public void setSelected(FlightDTO selected) {
		this.selected = selected;
	}
	
}
