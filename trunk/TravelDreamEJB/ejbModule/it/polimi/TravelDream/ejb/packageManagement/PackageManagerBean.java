package it.polimi.TravelDream.ejb.packageManagement;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.polimi.TravelDream.ejb.packageManagement.dto.*;
import it.polimi.TravelDream.ejb.entities.Package;

@Stateless
@LocalBean
public class PackageManagerBean implements PackageMgr{
	
	@PersistenceContext
    private EntityManager em;
	
	//ritorna la lista di tutti i pacchetti standard attualmente presenti nel db
	public List<Package> getAllStandard() {
    	return em.createNamedQuery(Package.FIND_ALL_STANDARDP, Package.class)
                .getResultList();
    }
	
	@Override
	public List<PackageDTO> getAllPackagesDTO() {
		List<PackageDTO> allPackages = convertToDTO(getAllStandard());
		return allPackages;
	}
	
	private List<PackageDTO> convertToDTO(List<Package> ps) {
		List<PackageDTO> allPackages = new ArrayList<PackageDTO>();
		for(Package p : ps){
			PackageDTO packageDTO = new PackageDTO();
			packageDTO.setIdPackage(p.getIdPackage());
			packageDTO.setTitle(p.getTitle());
			packageDTO.setType(p.getType());
			packageDTO.setDescription(p.getDescription());
			allPackages.add(packageDTO);
		}
			return allPackages;
		}
	
}

