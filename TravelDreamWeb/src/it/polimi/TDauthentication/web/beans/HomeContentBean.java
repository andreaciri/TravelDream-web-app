package it.polimi.TDauthentication.web.beans;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;

import it.polimi.TravelDream.ejb.eaos.HomeContent;

@ManagedBean
@RequestScoped
public class HomeContentBean {

	@EJB
	private HomeContent homeContent;
	
	public HomeContentBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String getAdminHome () {
		return homeContent.getAdminHome();
		
	}
	public String getUserHome () {
		return homeContent.getUserHome();
	}
	
}
