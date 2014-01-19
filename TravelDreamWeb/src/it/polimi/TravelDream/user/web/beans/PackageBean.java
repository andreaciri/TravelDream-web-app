package it.polimi.TravelDream.user.web.beans;
import java.io.Serializable;


import it.polimi.TravelDream.ejb.packageManagement.PackageMgr;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;  
import org.primefaces.event.ToggleEvent; 


@ManagedBean(name="packageBean")
@ViewScoped
public class PackageBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PackageBean(){
	}
	
	@EJB
	private PackageMgr packageMgr;
	
	public String getTitle() {
		return packageMgr.getPackageDTO().getTitle();
	}
	
	public String getDescription() {
		return packageMgr.getPackageDTO().getDescription();
	}
	
	public String getType() {
		return packageMgr.getPackageDTO().getType();
	}
	
	public int getIdPackage() {
		return packageMgr.getPackageDTO().getIdPackage();
	}
	
	public class FieldsetBean {  
		  
	    public void handleToggle(ToggleEvent event) {  
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fieldset Toggled", "Visibility:" + event.getVisibility());  
	  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
	    }  
	}
	
}
