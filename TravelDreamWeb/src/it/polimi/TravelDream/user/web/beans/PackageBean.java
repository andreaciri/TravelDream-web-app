package it.polimi.TravelDream.user.web.beans;

import java.io.Serializable;
import java.util.List;

import it.polimi.TravelDream.ejb.packageManagement.PackageMgr;
import it.polimi.TravelDream.ejb.packageManagement.dto.PackageDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

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
		packageMgr.delete(idPack);
		refreshPage();
	}
	
	public void buy(){
		packageMgr.buy(idPackage, guests);
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("buyDialog.show();");
	}
	
	protected void refreshPage() {
		FacesContext fc = FacesContext.getCurrentInstance();
		String refreshpage = fc.getViewRoot().getViewId();
//		System.out.println(refreshpage);
		if(refreshpage.equals("/users/savedPackages.xhtml")){
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("packDelete.show();");
			return;
		}
		ViewHandler ViewH =fc.getApplication().getViewHandler();
		UIViewRoot UIV = ViewH.createView(fc,refreshpage);
		UIV.setViewId(refreshpage);
		fc.setViewRoot(UIV);
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