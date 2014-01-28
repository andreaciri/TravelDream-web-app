package it.polimi.TravelDream.user.web.search.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import it.polimi.TravelDream.ejb.packageManagement.PackageMgr;
import it.polimi.TravelDream.ejb.packageManagement.dto.PackageDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;


@ManagedBean(name="searchPackageBean")
@SessionScoped
public class SearchPackageBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PackageMgr packageMgr;    
	
	private int idPackage;
	
	private PackageDTO selectedPackage; 
	
	private String keyword;
		
	public SearchPackageBean(){
		System.out.println("costruttore - id="+idPackage);
	}
	
	@PostConstruct
	public void afterCunstruct(){
		System.out.println("post costruttore - id="+idPackage);
		System.out.println("post costruttore - keyword="+keyword);
	}
	
	public void handleSearchById(){
		System.out.println("HANDLE - ID:"+idPackage);
		selectedPackage = packageMgr.getCustomPackageDTO(idPackage);
		if(selectedPackage == null){
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("invalidId.show();");
		}
		else
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("customPackageDetail.xhtml");
		} catch (IOException e) {
			e.printStackTrace();;
		}
		return;
	}
	
	
	public List<PackageDTO> getAllPackages() {
		return packageMgr.getAllPackagesDTO();
	}
	
	public List<PackageDTO> getFoundPackages() {
		System.out.println("getFoundPackages - keyword="+keyword);
		return packageMgr.getStandardPackageDTO(keyword);
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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
  
}