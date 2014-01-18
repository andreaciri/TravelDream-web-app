package it.polimi.TravelDream.ejb.compManagement;

import it.polimi.TravelDream.ejb.compManagement.dto.*;
import it.polimi.TravelDream.ejb.entities.Flight;

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
			newFlight.setDeparturePlace(((FlightDTO) newComp).getDeparturePlace());
			newFlight.setArrivalPlace(((FlightDTO) newComp).getArrivalPlace());
			//cercare come salvare utils.date in sql.date
			
			System.out.println(newFlight.getDeparturePlace() +", "+ newFlight.getArrivalPlace());
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


}
