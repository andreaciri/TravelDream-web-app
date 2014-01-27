package it.polimi.TravelDream.ejb.compManagement;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import it.polimi.TravelDream.ejb.compManagement.dto.*;
import it.polimi.TravelDream.ejb.entities.Excursion;
import it.polimi.TravelDream.ejb.entities.Flight;
import it.polimi.TravelDream.ejb.entities.Hotel;
import it.polimi.TravelDream.ejb.entities.Component;
import it.polimi.TravelDream.ejb.entities.Package;
import it.polimi.TravelDream.ejb.packageManagement.PackageManagerBean;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@LocalBean
public class CompManagerBean implements CompMgrInterface {

	@PersistenceContext
    private EntityManager em;
	
	@EJB
	PackageManagerBean packMgr;
	
	@Override
	public void save(ComponentDTO newComp) {
		if(newComp instanceof FlightDTO){
			Flight newFlight = (Flight) convertToEntity(newComp);
			
			em.persist(newFlight);
			System.out.println("New flight added to database:"+newComp.getTitle()+" "+newComp.getDescription()
								+" "+newComp.getPrice()+" "+((FlightDTO) newComp).getDeparturePlace()+" "+((FlightDTO) newComp).getDepartureDate().getTime());
		}
		
		else if (newComp instanceof HotelDTO){
			Hotel newHotel = (Hotel) convertToEntity(newComp);
			
			em.persist(newHotel);
			
		}

		else if(newComp instanceof ExcursionDTO){
			Excursion newExcursion = (Excursion) convertToEntity(newComp); 
					
			em.persist(newExcursion);
			System.out.println("New Excursion added to database:");
			
		}
		
	}

	@Override
	public void delete(int idComp) {
		Component toRemove = em.find(Component.class, idComp);
		for (Package p : getCriticalPack(toRemove)){
			em.remove(p);
			System.out.println("rimozione pacchetto "+p.getType()+" vincolato: "+p.getTitle()+" - id: "+p.getIdPackage());
		}
		em.remove(toRemove);
	}
	
	private List<Package> getCriticalPack(Component c){
		List<Package> criticalList = new ArrayList<Package>();
		for ( Package p : c.getPackages()){
			if(p.getType().equals("standard") && 
					(c instanceof Flight || c instanceof Hotel)){
				criticalList.add(p);				
			}
			if(p.getType().equals("custom") && p.getComponents().size() < 1){
				criticalList.add(p);
			}
	}
		return criticalList;
}

	@Override
	public ComponentDTO getComponentDTO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* QUERY CHE RESTITUISCONO LISTE DI OGGETTI ENTITA' */
	public List<Component> getAllComponent(){
		
		//createNamedQuery riceve nel costruttore il nome della query, e la classe del risultato
		return em.createNamedQuery(Component.FIND_ALL, Component.class).getResultList();
	}
	
	public List<Flight> getAllFlights(){
		return em.createNamedQuery(Component.FIND_FLIGHTS, Flight.class).getResultList();
	}
	
	public List<Hotel> getAllHotels(){
		return em.createNamedQuery(Component.FIND_HOTELS, Hotel.class).getResultList();
	}
	
	public List<Excursion> getAllExcs(){
		return em.createNamedQuery(Component.FIND_EXCS, Excursion.class).getResultList();
	}

	/* QUERY CHE RESTITUISCONO LISTE DI OGGETTI DTO */

	public List<ComponentDTO> getAllComponentDTO () {
		List<ComponentDTO> DTOList = new ArrayList<ComponentDTO>();
		List<Component> compList = getAllComponent();
		for(Component c : compList){
			DTOList.add(convertToDTO(c));
		}
		return DTOList;
	}
	
	public List<FlightDTO> getAllFlightsDTO () {
		List <FlightDTO> DTOList = new ArrayList<FlightDTO>();
		List<Flight> flightList = getAllFlights();
		for(Flight f : flightList){
			DTOList.add((FlightDTO) convertToDTO(f));
		}
		return DTOList;
	}
	
	public List<HotelDTO> getAllHotelsDTO () {
		List <HotelDTO> DTOList = new ArrayList<HotelDTO>();
		List<Hotel> hotelList = getAllHotels();
		for (Hotel h : hotelList){
			DTOList.add((HotelDTO) convertToDTO(h));
		}
		return DTOList;
	}
	
	public List<ExcursionDTO> getAllExcsDTO () {
		List <ExcursionDTO> DTOList = new ArrayList<ExcursionDTO>();
		List<Excursion> excursionList = getAllExcs();
		for (Excursion e : excursionList){
			DTOList.add((ExcursionDTO) convertToDTO(e));
		}
		return DTOList;
	}
	
	

	/* converte una entita' componente in un DTO  */
	public ComponentDTO convertToDTO (Component c) {
		ComponentDTO newDTO;
		if(c instanceof Flight){
			newDTO = new FlightDTO(c.getName(), c.getDescription(), c.getPrice(), c.getIdComponent());
			((FlightDTO) newDTO).setDeparturePlace(((Flight) c).getDeparturePlace());
			((FlightDTO) newDTO).setDepartureDate(((Flight) c).getDepartureDate());
			((FlightDTO) newDTO).setArrivalPlace(((Flight) c).getArrivalPlace());
			((FlightDTO) newDTO).setReturnDate(((Flight) c).getReturnDate());
		}
		else if(c instanceof Hotel){
			newDTO = new HotelDTO(c.getName(), c.getDescription(), c.getPrice(), c.getIdComponent());
			((HotelDTO) newDTO).setPlace(((Hotel) c).getPlace());
			((HotelDTO) newDTO).setCheckin(((Hotel) c).getCheckin());
			((HotelDTO) newDTO).setCheckout(((Hotel) c).getCheckout());
		}
		else if(c instanceof Excursion){
			newDTO = new ExcursionDTO(c.getName(), c.getDescription(), c.getPrice(), c.getIdComponent());
			((ExcursionDTO) newDTO).setPlace(((Excursion) c).getPlace());
			((ExcursionDTO) newDTO).setStart(((Excursion) c).getStart());
			((ExcursionDTO) newDTO).setFinish(((Excursion) c).getFinish());
		}
		else {
			System.out.println("compMgrBean: component not recognised");
			return null;}
//		newDTO.setCriticalPacks(packMgr.convertToDTO(getCriticalPack(c)));
		return newDTO;
	}
	
	public Component convertToEntity (ComponentDTO c){
		Component newEntity;
		if(c instanceof FlightDTO){
			newEntity = new Flight(c.getTitle(), c.getDescription(), c.getPrice(), c.getIdComponent(), "FLG");
			((Flight) newEntity).setDepartureDate(convertDate(((FlightDTO) c).getDepartureDate()));
			((Flight) newEntity).setReturnDate(convertDate(((FlightDTO) c).getReturnDate()));
			((Flight) newEntity).setDeparturePlace(((FlightDTO) c).getDeparturePlace());
			((Flight) newEntity).setArrivalPlace(((FlightDTO) c).getArrivalPlace());
		}
		else if(c instanceof HotelDTO){
			newEntity = new Hotel(c.getTitle(), c.getDescription(), c.getPrice(), c.getIdComponent(), "HTL");
			((Hotel) newEntity).setPlace(((HotelDTO) c).getPlace());
			((Hotel) newEntity).setCheckin(convertDate(((HotelDTO) c).getCheckin()));
			((Hotel) newEntity).setCheckout(convertDate(((HotelDTO) c).getCheckout()));
		}
		else if(c instanceof ExcursionDTO){
			newEntity = new Excursion (c.getTitle(), c.getDescription(), c.getPrice(), c.getIdComponent(), "XCR");
			((Excursion) newEntity).setPlace(((ExcursionDTO) c).getPlace());
			((Excursion) newEntity).setStart(convertDate(((ExcursionDTO) c).getStart()));
			((Excursion) newEntity).setFinish(convertDate(((ExcursionDTO) c).getFinish()));
		}
		else {
			System.out.println("compMgrBean: componentDTO not recognised");
			return null;}
		return newEntity;
	}
	
	public java.sql.Date convertDate (java.util.Date d) {
		return new java.sql.Date(d.getTime());
	}
}
