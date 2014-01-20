package it.polimi.TravelDream.web.newPackage.beans;

import it.polimi.TravelDream.ejb.compManagement.CompMgrInterface;
import it.polimi.TravelDream.ejb.compManagement.dto.*;

import java.io.Serializable;
import java.util.List;

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
	
	
	public NewPackageBean(){
	}
	
	public void newPackPreRender(){
		flights = compMgr.getAllFlightsDTO();
		hotels = compMgr.getAllHotelsDTO();
		excursions = compMgr.getAllExcsDTO();
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
	
}
