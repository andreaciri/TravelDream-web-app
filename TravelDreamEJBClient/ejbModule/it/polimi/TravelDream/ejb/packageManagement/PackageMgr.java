package it.polimi.TravelDream.ejb.packageManagement;

import java.util.List;

import it.polimi.TravelDream.ejb.packageManagement.dto.PackageDTO;

import javax.ejb.Local;

@Local
public interface PackageMgr {
	
	public List<PackageDTO> getAllPackagesDTO();
	public PackageDTO getselectedPackageDTO();
	
}

