package it.polimi.TravelDream.ejb.compManagement;

import it.polimi.TravelDream.ejb.compManagement.dto.ComponentDTO;

import javax.ejb.Local;


@Local
public interface CompMgrInterface {
	
	public void save(ComponentDTO newComp);
	public void delete();
	public ComponentDTO getComponentDTO();

}
