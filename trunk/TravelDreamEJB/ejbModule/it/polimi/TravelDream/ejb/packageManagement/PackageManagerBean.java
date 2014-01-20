package it.polimi.TravelDream.ejb.packageManagement;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
	
	//* converte la lista di pacchetti standard in DTO *//
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
	
	//* ritorna il pacchetto selezionato cercandolo via id nel db *//
	public Package getSelectedFromDB(EntityManager em, int idPackage){
		TypedQuery<Package> query = em.createNamedQuery(Package.FIND_PACKAGE_BY_ID, Package.class);
		return query.setParameter("idPackage", idPackage).getSingleResult();
	}
	
	//* converte il singolo pacchetto in DTO *//
	private PackageDTO convertSelectedToDTO(Package p){
		PackageDTO packageDTO = new PackageDTO();
		packageDTO.setIdPackage(p.getIdPackage());
		packageDTO.setTitle(p.getTitle());
		packageDTO.setType(p.getType());
		packageDTO.setDescription(p.getDescription());
		return packageDTO;
	}

	//* ritorna il pacchettoDTO selezionato *//
	@Override
	public PackageDTO getselectedPackageDTO(int id) {
		PackageDTO select = convertSelectedToDTO(getSelectedFromDB(em,id));
		return select;
	}
	
	//* ritorna la lista di pacchettiDTO *//
	@Override
	public List<PackageDTO> getAllPackagesDTO() {
		List<PackageDTO> allPackages = convertToDTO(getAllStandard());
		return allPackages;
	}
}

