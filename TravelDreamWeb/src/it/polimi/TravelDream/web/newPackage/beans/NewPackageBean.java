package it.polimi.TravelDream.web.newPackage.beans;

import it.polimi.TravelDream.ejb.compManagement.CompMgrInterface;
import it.polimi.TravelDream.ejb.compManagement.dto.*;
import it.polimi.TravelDream.ejb.packageManagement.PackageMgr;
import it.polimi.TravelDream.ejb.packageManagement.dto.PackageDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

@ManagedBean(name="newPackage")
@ViewScoped
public class NewPackageBean implements Serializable{

	@EJB
	private CompMgrInterface compMgr;
	
	@EJB
	private PackageMgr packMgr;
	
	private List<FlightDTO> flights;
	private List<HotelDTO> hotels;
	private List<ExcursionDTO> excursions;
	
	//selected non puo' essere una lista per dataTable con selezione singola
	private FlightDTO selectedFlight;
	private HotelDTO selectedHotel;
	private List<ExcursionDTO> selectedExcs;
	
	private PackageDTO newPack;
	
	public NewPackageBean(){
	}
	
	@PostConstruct
	public void afterConstruct() {
		newPack = new PackageDTO();
		flights = compMgr.getAllFlightsDTO();
		hotels = compMgr.getAllHotelsDTO();
		excursions = compMgr.getAllExcsDTO();
		selectedExcs = new ArrayList<ExcursionDTO>();
		selectedFlight = null;
		selectedHotel = null;
		
	}
	
	public void handleNewStandardPack(){
		RequestContext context = RequestContext.getCurrentInstance();		
		if(selectedFlight == null || selectedHotel == null){
			context.execute("notValidDialog.show();");	
		}
		else if(newPack.getTitle().equals("")){
			context.execute("notValidTitle.show();");
		}
		else
		{
			List<ComponentDTO> content = new ArrayList<ComponentDTO>();
			content.add(selectedFlight);
			content.add(selectedHotel);
			content.addAll(selectedExcs);
			newPack.setComponents(content);
			newPack.setType("standard");
			packMgr.save(newPack);
			context.execute("newPackDialog.show();");
		}
		
		
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

	public FlightDTO getSelectedFlight() {
		return selectedFlight;
	}

	public void setSelectedFlight(FlightDTO selectedFlight) {
		this.selectedFlight = selectedFlight;
	}

	public HotelDTO getSelectedHotel() {
		return selectedHotel;
	}

	public void setSelectedHotel(HotelDTO selectedHotel) {
		this.selectedHotel = selectedHotel;
	}

	public List<ExcursionDTO> getSelectedExcs() {
		return selectedExcs;
	}

	public void setSelectedExcs(List<ExcursionDTO> selectedExcs) {
		this.selectedExcs = selectedExcs;
	}

	public PackageDTO getNewPack() {
		return newPack;
	}

	public void setNewPack(PackageDTO newPack) {
		this.newPack = newPack;
	}

	
}
