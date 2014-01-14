package it.polimi.TravelDream.authentication.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name="logoutBean")
@RequestScoped
public class LogoutBean {
	
	public String logout() {
	    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	    return "/home?faces-redirect=true";
	  }


}
