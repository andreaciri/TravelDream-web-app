package it.polimi.TravelDreamAuthentication.web.beans;



import it.polimi.TravelDream.ejb.userManagement.UsrMgr;

import javax.ejb.EJB;

public class UserBean {
	
	@EJB
	private UsrMgr usrMgr;
	public String getUsername() {
		
		return usrMgr.getUserDTO().getUsername();
	}
	
}
