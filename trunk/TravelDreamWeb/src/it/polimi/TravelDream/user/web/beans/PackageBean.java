package it.polimi.TravelDream.user.web.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import it.polimi.TravelDream.ejb.packageManagement.PackageMgr;
import it.polimi.TravelDream.ejb.packageManagement.dto.PackageDTO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name="packageBean")
@SessionScoped
public class PackageBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PackageMgr packageMgr;
	
	private int idPackage=0;
	
	private PackageDTO selectedPackage; 
		
	public PackageBean(){
		System.out.println("costruttore - id="+idPackage);
	}
	
	public void handleSearchById(String type){
		System.out.println("HANDLE - ID:"+idPackage);
		if(type.equals("custom")){
			selectCustom();
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("customPackageDetail.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
		}
	}
	
	public String reset() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	    return "idPackage";
	  }
	
	public void choose(int idPackage){
		selectedPackage = packageMgr.getselectedPackageDTO(idPackage);
		return;
	}
	
	public void selectCustom(){
		System.out.println("selectCustom - ID= "+idPackage);
		selectedPackage = packageMgr.getCustomPackageDTO(idPackage);
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