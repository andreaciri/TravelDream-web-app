package it.polimi.TravelDream.ejb.packageManagement;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import it.polimi.TravelDream.ejb.packageManagement.dto.*;
import it.polimi.TravelDream.ejb.entities.Package;
import it.polimi.TravelDream.ejb.entities.User;

@Stateless
@LocalBean
public class PackageManagerBean implements PackageMgr{
	
	@PersistenceContext
    private EntityManager em;
	
	@Resource
	private EJBContext context;
	
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

	
//	@Override
//	public PackageDTO getselectedPackageDTO() {
//		PackageDTO selectedPackage = convertSelectedToDTO(getSelectedPackage(em,idPackage));
//		return selectedPackage;
//	}
	
//	public Package getSelectedPackage(EntityManager em, int idPackage){
//		TypedQuery<Package> query = em.createQuery("SELECT p FROM Package p WHERE p.idPackage = :idPackage", Package.class);
//		return query.setParameter("idPackage", idPackage).getSingleResult();
//	}	
	
	public Package find(int idPackage) {
    	return em.find(Package.class, idPackage);
    }
	
	
	private PackageDTO convertSelectedToDTO(Package p){
		PackageDTO packageDTO = new PackageDTO();
		packageDTO.setIdPackage(p.getIdPackage());
		packageDTO.setTitle(p.getTitle());
		packageDTO.setType(p.getType());
		packageDTO.setDescription(p.getDescription());
		return packageDTO;
	}

	@Override
	public PackageDTO getselectedPackageDTO() {
		// TODO Auto-generated method stub
		return null;
	}
}

