package it.polimi.TravelDream.ejb.compManagement;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import it.polimi.TravelDream.ejb.compManagement.dto.*;
import it.polimi.TravelDream.ejb.entities.Excursion;
import it.polimi.TravelDream.ejb.entities.Flight;
import it.polimi.TravelDream.ejb.entities.Hotel;
import it.polimi.TravelDream.ejb.entities.Component;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@LocalBean
public class CompManagerBean implements CompMgrInterface {

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public void save(ComponentDTO newComp) {
		if(newComp instanceof FlightDTO){
			Flight newFlight = new Flight();
			newFlight.setName(newComp.getTitle());
			newFlight.setIdType("FLG");
			newFlight.setDescription(newComp.getDescription());
			newFlight.setPrice(newComp.getPrice());
			newFlight.setDeparturePlace(((FlightDTO) newComp).getDeparturePlace());
			newFlight.setArrivalPlace(((FlightDTO) newComp).getArrivalPlace());
			
			//convertion from utils.date to sql.date - NON CORRETTA - DA CAMBIARE
			
			newFlight.setDepartureDate(new java.sql.Date(((FlightDTO) newComp).getDepartureDate().getTime()));
			newFlight.setReturnDate(new java.sql.Date(((FlightDTO) newComp).getReturnDate().getTime()));
			
			em.persist(newFlight);
			System.out.println("New flight added to database:"+newComp.getTitle()+" "+newComp.getDescription()
								+" "+newComp.getPrice()+" "+((FlightDTO) newComp).getDeparturePlace()+" "+((FlightDTO) newComp).getDepartureDate().getTime());
		}
		
		else if (newComp instanceof HotelDTO){
			Hotel newHotel = new Hotel();
			newHotel.setName(newComp.getTitle());
			newHotel.setIdType("HTL");
			newHotel.setDescription(newComp.getDescription());
			newHotel.setPrice(newComp.getPrice());
			newHotel.setPlace(((HotelDTO) newComp).getPlace());
			newHotel.setCheckin(new java.sql.Date(((HotelDTO) newComp).getCheckin().getTime()));
			newHotel.setCheckout(new java.sql.Date(((HotelDTO) newComp).getCheckout().getTime()));
			em.persist(newHotel);
			
		}

		else if(newComp instanceof ExcursionDTO){
			Excursion newExcursion = new Excursion();
			newExcursion.setName(newComp.getTitle());
			newExcursion.setIdType("XCR");
			newExcursion.setDescription(newComp.getDescription());
			newExcursion.setPrice(newComp.getPrice());
			newExcursion.setPlace(((ExcursionDTO) newComp).getPlace());
			newExcursion.setStart(new java.sql.Date(((ExcursionDTO) newComp).getStart().getTime()));
			newExcursion.setFinish(new java.sql.Date(((ExcursionDTO) newComp).getFinish().getTime()));
			em.persist(newExcursion);
			System.out.println("New Excursion added to database:");
			
		}
		
	}

	@Override
	public void delete() {
		
	}

	@Override
	public ComponentDTO getComponentDTO() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/* restituisce tutti i componenti come oggetti entita' */
	public List<Component> getAllComponent(){
		
		//createNamedQuery riceve nel costruttore il nome della query, e la classe del risultato
		return em.createNamedQuery(Component.FIND_ALL, Component.class).getResultList();
	}

	/* converte una entita' componente in un DTO  */
	private ComponentDTO convertToDTO (Component c) {
		ComponentDTO newDTO;
		if(c instanceof Flight){
			newDTO = new FlightDTO(c.getName(), c.getDescription(), c.getPrice());
			((FlightDTO) newDTO).setDeparturePlace(((Flight) c).getDeparturePlace());
			((FlightDTO) newDTO).setDepartureDate(((Flight) c).getDepartureDate());
			((FlightDTO) newDTO).setArrivalPlace(((Flight) c).getArrivalPlace());
			((FlightDTO) newDTO).setReturnDate(((Flight) c).getReturnDate());
		}
		else if(c instanceof Hotel){
			newDTO = new HotelDTO(c.getName(), c.getDescription(), c.getPrice());
			((HotelDTO) newDTO).setPlace(((Hotel) c).getPlace());
			((HotelDTO) newDTO).setCheckin(((Hotel) c).getCheckin());
			((HotelDTO) newDTO).setCheckout(((Hotel) c).getCheckout());
		}
		else if(c instanceof Excursion){
			newDTO = new ExcursionDTO(c.getName(), c.getDescription(), c.getPrice());
			((ExcursionDTO) newDTO).setPlace(((Excursion) c).getPlace());
			((ExcursionDTO) newDTO).setStart(((Excursion) c).getStart());
			((ExcursionDTO) newDTO).setFinish(((Excursion) c).getFinish());
		}
		else {
			System.out.println("compMgrBean: component not recognised");
			return null;}
		
		return newDTO;
	}
	
	public List<ComponentDTO> getAllComponentDTO () {
		List<ComponentDTO> DTOList = new ArrayList<ComponentDTO>();
		List<Component> compList = getAllComponent();
		for(Component c : compList){
			DTOList.add(convertToDTO(c));
		}
		return DTOList;
	}
	
	
	
}
