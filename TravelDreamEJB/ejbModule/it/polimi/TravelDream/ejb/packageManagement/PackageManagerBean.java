package it.polimi.TravelDream.ejb.packageManagement;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.polimi.TravelDream.ejb.packageManagement.dto.*;
import it.polimi.TravelDream.ejb.entities.*;

@Stateless
@LocalBean
public class PackageManagerBean implements PackageMgr{
	
	@PersistenceContext
    private EntityManager em;
	
//	public List<Package> getAllPackages() {
//    	return em.createNamedQuery(Package.FIND_ALL_P, Package.class)
//                .getResultList();
//    }
	
	@Override
	public PackageDTO getPackageDTO() {
//		PackageDTO packageDTO = convertToDTO(getPackage());
		return null;
	}
	
	
//	private PackageDTO convertToDTO(Package p) {
//		PackageDTO packageDTO = new PackageDTO();
//		packageDTO.setIdPackage(p.getIdPackage());
//		packageDTO.setTitle(p.getTitle());
//		packageDTO.setTitle(p.getType());
//		packageDTO.setDescription(p.getDescription());
//		return packageDTO;
//	}
}

