package it.polimi.TravelDream.ejb.eaos;




import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HomePage
 */
@Stateless
public class HomeBean implements HomeContent {

    /**
     * Default constructor. 
     */
    public HomeBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	@RolesAllowed({"ADMIN"})
	public String getAdminHome() {
		return "Admin homepage: create package, create component...";
	}

	@Override
	@RolesAllowed({"USER"})
	public String getUserHome() {
		return "User homepage: oktoberfest, maldive...";
	}

}
