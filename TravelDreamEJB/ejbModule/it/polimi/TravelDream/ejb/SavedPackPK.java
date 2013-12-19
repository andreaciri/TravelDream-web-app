package it.polimi.TravelDream.ejb;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SAVED_PACK database table.
 * 
 */
@Embeddable
public class SavedPackPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String username;

	@Column(insertable=false, updatable=false)
	private int idPackage;

	public SavedPackPK() {
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getIdPackage() {
		return this.idPackage;
	}
	public void setIdPackage(int idPackage) {
		this.idPackage = idPackage;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SavedPackPK)) {
			return false;
		}
		SavedPackPK castOther = (SavedPackPK)other;
		return 
			this.username.equals(castOther.username)
			&& (this.idPackage == castOther.idPackage);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.username.hashCode();
		hash = hash * prime + this.idPackage;
		
		return hash;
	}
}