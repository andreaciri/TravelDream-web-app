package it.polimi.TravelDream.ejb.packageManagement;

import java.util.List;

import it.polimi.TravelDream.ejb.packageManagement.dto.PackageDTO;

import javax.ejb.Local;

@Local
public interface PackageMgr {
	
	public List<PackageDTO> getAllPackagesDTO();
	public PackageDTO getselectedPackageDTO(int idPackage);
	public PackageDTO getCustomPackageDTO(int idPackage);
	public List<PackageDTO> getStandardPackageDTO(String keyword);
	public void save(PackageDTO newPack);
	public PackageDTO getPackDTOById(int idPackage);
	
}

