package it.polimi.TDautentication.ejb.eaos;

import javax.ejb.Local;

@Local
public interface HomeContent {

	public String getAdminHome();

	public String getUserHome();
	
}
