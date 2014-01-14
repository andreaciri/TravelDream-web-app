package it.polimi.TravelDream.authentication.web.beans;

import it.polimi.TravelDream.ejb.userManagement.UsrMgr;
import it.polimi.TravelDream.ejb.userManagement.dto.UserDTO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="registerBean")
@RequestScoped
public class RegisterBean {
	
	@EJB
	private UsrMgr usrMgr;

	private UserDTO user;
	
	public RegisterBean() {
		user = new UserDTO();
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	public String register() {
		usrMgr.save(user);
		return "home?faces-redirect=true";
	}
}
