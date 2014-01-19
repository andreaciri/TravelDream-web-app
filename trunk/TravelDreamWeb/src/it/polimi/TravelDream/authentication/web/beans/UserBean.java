package it.polimi.TravelDream.authentication.web.beans;


import it.polimi.TravelDream.ejb.userManagement.UsrMgr;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;  


@ManagedBean(name="userBean")
@RequestScoped
public class UserBean {

	public UserBean () {	
	}
	
	@EJB
	private UsrMgr usrMgr;
	
	public String getUsername () {
		return usrMgr.getUserDTO().getUsername();
	} 
	
	
}
