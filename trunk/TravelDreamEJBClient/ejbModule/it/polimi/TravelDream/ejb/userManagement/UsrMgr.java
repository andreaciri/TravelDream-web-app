package it.polimi.TravelDream.ejb.userManagement;

import javax.ejb.Local;

import it.polimi.TravelDream.ejb.userManagement.dto.UserDTO;


@Local
public interface UsrMgr {
	public void save(UserDTO user);
	
	public void update(UserDTO user);
	
	public void unregister();
	
	public UserDTO getUserDTO();
	
}
