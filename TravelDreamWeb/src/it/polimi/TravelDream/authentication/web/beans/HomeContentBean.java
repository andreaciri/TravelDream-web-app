package it.polimi.TravelDream.authentication.web.beans;

import java.io.Serializable;

import it.polimi.TravelDream.ejb.eaos.HomeContent;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name="homeContentBean")
@SessionScoped
public class HomeContentBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomeContentBean () {
	}
	
	@EJB
	private HomeContent homeContent;
	
	public String getAdminHome() {
		return homeContent.getAdminHome();
	}
	
	public String getUserHome() {
		return homeContent.getUserHome();
	}
}
