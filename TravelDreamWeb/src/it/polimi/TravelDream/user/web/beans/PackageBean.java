package it.polimi.TravelDream.user.web.beans;
import java.io.Serializable;
import java.util.List;


import it.polimi.TravelDream.ejb.packageManagement.PackageMgr;
import it.polimi.TravelDream.ejb.packageManagement.dto.PackageDTO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="packageBean")
@ViewScoped
public class PackageBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PackageMgr packageMgr;
		
	public PackageBean(){
	}
	
	public List<PackageDTO> getAllPackages() {
		return packageMgr.getAllPackagesDTO();
	}	
  
}