package it.polimi.TravelDream.authentication.web.beans;


import it.polimi.TravelDream.ejb.userManagement.UsrMgr;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;  
import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  
import org.primefaces.event.ToggleEvent;  


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
	  
	public class FieldsetBean {  
	  
	    public void handleToggle(ToggleEvent event) {  
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fieldset Toggled", "Visibility:" + event.getVisibility());  
	  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
	    }  
	} 
	
	
}
