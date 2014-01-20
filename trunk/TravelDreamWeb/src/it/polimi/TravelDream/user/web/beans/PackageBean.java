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
	
	private int idPackage;
	
	private PackageDTO selectedPackage; 
		
	public PackageBean(){
	}
	
	public void choose(int idPackage){
		selectedPackage = packageMgr.getselectedPackageDTO(idPackage);
		return;
	}
	
	public List<PackageDTO> getAllPackages() {
		return packageMgr.getAllPackagesDTO();
	}	
	
	public int getIdPackage() {
		return idPackage;
	}

	public void setIdPackage(int idPackage) {
		this.idPackage = idPackage;
	}

	public PackageDTO getSelectedPackage() {
		return selectedPackage;
	}

	public void setSelectedPackage(PackageDTO selectedPackage) {
		this.selectedPackage = selectedPackage;
	}
  
}