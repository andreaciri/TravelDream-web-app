package it.polimi.TravelDream.ejb.eaos;

import javax.ejb.Local;

@Local
public interface HomeContent {

	public String getAdminHome();

	public String getUserHome();
	
}
