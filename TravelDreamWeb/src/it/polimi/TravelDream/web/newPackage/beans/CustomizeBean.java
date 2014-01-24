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

@ViewScoped
@ManagedBean(name="customizeBean")
public class CustomizeBean implements Serializable{
	
	
	@EJB
	private CompMgrInterface compMgr;
	
	@EJB
	private PackageMgr packMgr;
	
	private int idPackage;
	private PackageDTO currentPack;
	private List<FlightDTO> flights;
	private List<HotelDTO> hotels;
	private List<ExcursionDTO> excursions;
	private List<FlightDTO> selectedFlights;
	private List<HotelDTO> selectedHotels;
	private List<ExcursionDTO> selectedExcs;
	
	
	public void initFromView() {
		System.out.println("CUSTOMIZE BEAN, FROM VIEW ACTION - ID = "+idPackage);
		flights = compMgr.getAllFlightsDTO();
		hotels = compMgr.getAllHotelsDTO();
		excursions = compMgr.getAllExcsDTO();
		currentPack = packMgr.getPackDTOById(idPackage);
		selectedFlights = new ArrayList<FlightDTO>();
		selectedHotels = new ArrayList<HotelDTO>();
		selectedExcs = new ArrayList<ExcursionDTO>();
		for(ComponentDTO c : currentPack.getComponents()){
			if(c instanceof FlightDTO){
				selectedFlights.add((FlightDTO) c);
			}
			else if(c instanceof HotelDTO){
				selectedHotels.add((HotelDTO) c);
			}
			else if(c instanceof ExcursionDTO){
				selectedExcs.add((ExcursionDTO) c);
			}
			else{System.out.println("CUSTOMIZE BEAN INIT - COMPONENT TYPE UNKNOWN");}
		}
	}
	
	public CustomizeBean() {System.out.println("CUSTOMIZE BEAN CONSTRUCTOR");}
	
	public void handleSavePack() {
		RequestContext context = RequestContext.getCurrentInstance();		
		if(selectedFlights.size() + selectedHotels.size() + selectedExcs.size() == 0){
			context.execute("notValidDialog.show();");	
		}
		else if(currentPack.getTitle().equals("")){
			context.execute("notValidTitle.show();");
		}
		else{
			List<ComponentDTO> content = new ArrayList<ComponentDTO>();
			content.addAll(selectedFlights);
			content.addAll(selectedHotels);
			content.addAll(selectedExcs);
			currentPack.setComponents(content);
			currentPack.setType("custom");
			packMgr.save(currentPack);
			context.execute("newPackDialog.show();");
		}
	}

	public int getIdPackage() {
		return idPackage;
	}

	public void setIdPackage(int idPackage) {
		this.idPackage = idPackage;
	}


	public PackageDTO getCurrentPack() {
		return currentPack;
	}


	public void setCurrentPack(PackageDTO currentPack) {
		this.currentPack = currentPack;
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


	public List<FlightDTO> getSelectedFlights() {
		return selectedFlights;
	}


	public void setSelectedFlights(List<FlightDTO> selectedFlights) {
		this.selectedFlights = selectedFlights;
	}


	public List<HotelDTO> getSelectedHotels() {
		return selectedHotels;
	}


	public void setSelectedHotels(List<HotelDTO> selectedHotels) {
		this.selectedHotels = selectedHotels;
	}


	public List<ExcursionDTO> getSelectedExcs() {
		return selectedExcs;
	}


	public void setSelectedExcs(List<ExcursionDTO> selectedExcs) {
		this.selectedExcs = selectedExcs;
	}
	
}
