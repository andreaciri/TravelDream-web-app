package it.polimi.TravelDream.user.web.beans;

import java.io.Serializable;
import java.util.List;

import it.polimi.TravelDream.ejb.packageManagement.PackageMgr;
import it.polimi.TravelDream.ejb.packageManagement.dto.PackageDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;


@ManagedBean(name="packageBean")
@ViewScoped
public class PackageBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PackageMgr packageMgr;    
	
	private int idPackage=0;
	
	private List<PackageDTO> allPackages;
	
	private PackageDTO selectedPackage; 
	
	private int guests;
		
	public PackageBean(){
	}
	
	@PostConstruct
	public void packageBeanPostConstruct() {
		allPackages = packageMgr.getAllPackagesDTO();
		guests = 1;
	}
	
	public void choose(int idPackage){
		selectedPackage = packageMgr.getselectedPackageDTO(idPackage);
		return;
	}
	
	public void delete(int idPack){
		System.out.println("DELETE ID"+idPack);
//		packageMgr.delete(idPack);
	}
	
	public void buy(){
		packageMgr.buy(idPackage, guests);
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

	
	public List<PackageDTO> getSavedPackages() {
		return packageMgr.getSavedPackagesDTO();
	}

	public List<PackageDTO> getAllPackages() {
		return allPackages;
	}

	public void setAllPackages(List<PackageDTO> allPackages) {
		this.allPackages = allPackages;
	}

	public int getGuests() {
		return guests;
	}

	public void setGuests(int guests) {
		this.guests = guests;
	}
  
}