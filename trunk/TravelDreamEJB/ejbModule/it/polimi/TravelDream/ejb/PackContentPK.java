package it.polimi.TravelDream.ejb;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PACK_CONTENT database table.
 * 
 */
@Embeddable
public class PackContentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idPackage;

	@Column(insertable=false, updatable=false)
	private int idComponent;

	public PackContentPK() {
	}
	public int getIdPackage() {
		return this.idPackage;
	}
	public void setIdPackage(int idPackage) {
		this.idPackage = idPackage;
	}
	public int getIdComponent() {
		return this.idComponent;
	}
	public void setIdComponent(int idComponent) {
		this.idComponent = idComponent;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PackContentPK)) {
			return false;
		}
		PackContentPK castOther = (PackContentPK)other;
		return 
			(this.idPackage == castOther.idPackage)
			&& (this.idComponent == castOther.idComponent);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPackage;
		hash = hash * prime + this.idComponent;
		
		return hash;
	}
}