package it.polimi.TravelDream.ejb.userManagement;



public interface UsrMgr {
	public void save(UserDTO user);
	
	public void update(UserDTO user);
	
	public void unregister();
	
	public UserDTO getUserDTO();
}
