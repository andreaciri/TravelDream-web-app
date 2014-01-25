package it.polimi.TravelDream.web.newPackage.beans;

import it.polimi.TravelDream.ejb.compManagement.CompMgrInterface;
import it.polimi.TravelDream.ejb.compManagement.dto.*;
import it.polimi.TravelDream.ejb.packageManagement.PackageMgr;
import it.polimi.TravelDream.ejb.packageManagement.dto.PackageDTO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;


@ViewScoped
@ManagedBean(name="modifyBean")
public class ModifyBean {

	@EJB
	private CompMgrInterface compMgr;
	
	@EJB
	private PackageMgr packMgr;
	
	private int idPackage;
	private PackageDTO currentPack;
	private List<FlightDTO> flights;
	private List<HotelDTO> hotels;
	private List<ExcursionDTO> excursions;
	
	//selected non puo' essere una lista per dataTable con selezione singola
	private FlightDTO selectedFlight;
	private HotelDTO selectedHotel;
	private List<ExcursionDTO> selectedExcs;
	
	public void initFromView() {
		System.out.println("MODIFY BEAN, FROM VIEW ACTION - ID = "+idPackage);
		flights = compMgr.getAllFlightsDTO();
		hotels = compMgr.getAllHotelsDTO();
		excursions = compMgr.getAllExcsDTO();
		selectedExcs = new ArrayList<ExcursionDTO>();
		currentPack = packMgr.getPackDTOById(idPackage);
		for(ComponentDTO c : currentPack.getComponents()){
			if(c instanceof FlightDTO){
				selectedFlight = ((FlightDTO) c);
			}
			else if(c instanceof HotelDTO){
				selectedHotel = ((HotelDTO) c);
			}
			else if(c instanceof ExcursionDTO){
				selectedExcs.add((ExcursionDTO) c);
			}
			else{System.out.println("MODIFY BEAN INIT - COMPONENT TYPE UNKNOWN");}
		}
	}
	
	public void handleModifyPack () {
		RequestContext context = RequestContext.getCurrentInstance();		
		if(selectedFlight == null || selectedHotel == null){
			context.execute("notValidDialog.show();");	
		}
		else if(currentPack.getTitle().equals("")){
			context.execute("notValidTitle.show();");
		}
		else{
			List<ComponentDTO> content = new ArrayList<ComponentDTO>();
			content.add(selectedFlight);
			content.add(selectedHotel);
			content.addAll(selectedExcs);
			currentPack.setComponents(content);
			packMgr.update(currentPack);
			context.execute("newPackDialog.show();");
		}
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
	
}
