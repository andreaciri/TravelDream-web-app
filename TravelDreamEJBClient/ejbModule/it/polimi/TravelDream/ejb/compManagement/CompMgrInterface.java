package it.polimi.TravelDream.ejb.compManagement;

import java.util.List;

import it.polimi.TravelDream.ejb.compManagement.dto.ComponentDTO;

import javax.ejb.Local;


@Local
public interface CompMgrInterface {
	
	public void save(ComponentDTO newComp);
	public void delete();
	public ComponentDTO getComponentDTO();
	public List<ComponentDTO> getAllComponentDTO();

}