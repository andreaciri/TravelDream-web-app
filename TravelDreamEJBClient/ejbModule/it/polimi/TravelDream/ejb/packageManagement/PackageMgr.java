package it.polimi.TravelDream.ejb.packageManagement;

import it.polimi.TravelDream.ejb.packageManagement.dto.PackageDTO;
import javax.ejb.Local;

@Local
public interface PackageMgr {
	
	public PackageDTO getPackageDTO();
	
}

