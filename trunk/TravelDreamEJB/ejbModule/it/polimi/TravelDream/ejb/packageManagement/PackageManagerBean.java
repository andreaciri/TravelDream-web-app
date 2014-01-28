package it.polimi.TravelDream.ejb.packageManagement;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import it.polimi.TravelDream.ejb.packageManagement.dto.*;
import it.polimi.TravelDream.ejb.compManagement.CompManagerBean;
import it.polimi.TravelDream.ejb.compManagement.dto.ComponentDTO;
import it.polimi.TravelDream.ejb.entities.Component;
import it.polimi.TravelDream.ejb.entities.Package;
import it.polimi.TravelDream.ejb.entities.PurchasedPack;
import it.polimi.TravelDream.ejb.entities.User;


@Stateless
@LocalBean
public class PackageManagerBean implements PackageMgr{
	
	@PersistenceContext
    private EntityManager em;
	
	@EJB
	CompManagerBean compMan;
	
	@Resource
	private EJBContext context;
	
	//* ritorna la lista di tutti i pacchetti standard attualmente presenti nel db *//
	public List<Package> getAllStandard() {
    	return em.createNamedQuery(Package.FIND_ALL_STANDARDP, Package.class)
                .getResultList();
    }
	
	//* converte la lista di pacchetti standard in DTO *//
	public List<PackageDTO> convertToDTO(List<Package> ps) {
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
	
	//restituisce un pacchetto cercando l'id, independentemente dal tipo
	public Package getPackById (int idPackage){
		return  em.find(Package.class, idPackage);
	}
	
	//restituisce il DTO cercando l'id, indipendentemente dal tipo
	public PackageDTO getPackDTOById (int idPackage){
		 Package requestPack = getPackById(idPackage);
		 return convertSelectedToDTO(requestPack);
	}
	
	//* ritorna il pacchetto selezionato cercandolo via id nel db *//
	public Package getSelectedFromDB(int idPackage){
		TypedQuery<Package> query = em.createNamedQuery(Package.FIND_PACKAGE_BY_ID, Package.class);
		return query.setParameter("idPackage", idPackage).getSingleResult();
	}
	
	//* ritorna il pacchetto custom cercandolo via id nel db *//
	public Package getCustomFromDB(int idPackage){
		System.out.println("MANAGERBEAN - ID:"+idPackage);
		TypedQuery<Package> query = em.createNamedQuery(Package.FIND_CPACKAGE_BY_ID, Package.class);
		return query.setParameter("idPackage", idPackage).getSingleResult();
	}
	
	//* ritorna il pacchetto custom cercandolo via keyword nel db *//
	public List<Package> getStandardFromDB(String keyword){
		System.out.println("MANAGERBEAN - KEY:"+keyword);
		TypedQuery<Package> query = em.createNamedQuery(Package.FIND_SPACKAGE_BY_KEY, Package.class);
		return query.setParameter("keyword", "%"+keyword+"%").getResultList();
		}

	/* restituisce i pacchetti customizzati dall' utente loggato correntemente */
	public List<Package> getSavedPack() {
		User currentUser = em.find(User.class, context.getCallerPrincipal().getName());
		return currentUser.getPackages();
	}
	
	//* converte il singolo pacchetto in DTO *//
	private PackageDTO convertSelectedToDTO(Package p){
		PackageDTO packageDTO = new PackageDTO();
		packageDTO.setIdPackage(p.getIdPackage());
		packageDTO.setTitle(p.getTitle());
		packageDTO.setType(p.getType());
		packageDTO.setDescription(p.getDescription());
		for(Component c : p.getComponents()){
			packageDTO.addComponent(compMan.convertToDTO(c));
		}
		return packageDTO;
	}

	//* ritorna il pacchettoDTO selezionato *//
	@Override
	public PackageDTO getselectedPackageDTO(int id) {
		PackageDTO select = convertSelectedToDTO(getSelectedFromDB(id));
		return select;
	}
	
	//* ritorna il pacchettoCustomDTO cercato via id *//
	@Override
	public PackageDTO getCustomPackageDTO(int id) {
		PackageDTO select = convertSelectedToDTO(getCustomFromDB(id));
		return select;
		}
	
	//* ritorna la lista di pacchettiDTO *//
	@Override
	public List<PackageDTO> getAllPackagesDTO() {
		List<PackageDTO> allPackages = convertToDTO(getAllStandard());
		return allPackages;
	}

	@Override
	public void save(PackageDTO newPackDTO) {
		Package newPack;
		for(ComponentDTO c : newPackDTO.getComponents()){
			System.out.println(c.getClass().toString()+" "+c.getTitle());
		}
		newPack = new Package(newPackDTO);
		for (ComponentDTO c : newPackDTO.getComponents()){
			Component entity = em.find(Component.class, c.getIdComponent());
			newPack.addComponent(entity);
		}
		em.persist(newPack);
		addPackToUser(newPack);
		
	}
	
	public void buy(int idPackage, int guests){
		Package selectedPack = em.find(Package.class, idPackage);
		User currentUser = em.find(User.class, context.getCallerPrincipal().getName());
		PurchasedPack purchase = new PurchasedPack();
		purchase.setPurchasedPack(selectedPack);
		purchase.setUser(currentUser);
		purchase.setGuests(guests);
		int total = 0;
		for (Component c : selectedPack.getComponents()) {
			total = total + c.getPrice();
		}
		purchase.setTotalPrice(total*guests);
		em.persist(purchase);
	}
	
	@Override
	public void delete(int idPackage) {
		Package toRemove = em.find(Package.class, idPackage);
		User currentUser = em.find(User.class, context.getCallerPrincipal().getName());
		currentUser.removePackage(toRemove);
		System.out.println("RIMOZIONE PACCHETTO "+toRemove.getTitle()+" - ID = "+idPackage);
		em.remove(toRemove);
	}
	
	/* aggiorna titolo, descrizione, e lista componenti di un pacchetto */
	public void update(PackageDTO currentDTO) {
		Package currentPack = em.find(Package.class, currentDTO.getIdPackage());
		currentPack.setTitle(currentDTO.getTitle());
		currentPack.setDescription(currentDTO.getDescription());
		List<Component> newList = new ArrayList<Component>();
		for(ComponentDTO c : currentDTO.getComponents()){
			newList.add(compMan.convertToEntity(c));
		}
		currentPack.setComponents(newList);
		em.merge(currentPack);
	}
	
	private void addPackToUser(Package p) {
		User currentUser = em.find(User.class, context.getCallerPrincipal().getName());
		currentUser.addPackage(p);
		em.merge(currentUser);
	}

	//* ritorna il pacchettoStandardDTO cercato via keyword *//
	@Override
	public List<PackageDTO> getStandardPackageDTO(String keyword) {
		List<PackageDTO> select = convertToDTO(getStandardFromDB(keyword));
		return select;
		}

	//* ritorna la lista di pacchettiCustomDTO salvati dall'utente *//
	@Override
	public List<PackageDTO> getSavedPackagesDTO() {
		List<PackageDTO> select = convertToDTO(getSavedPack());
		return select;
	}
}

