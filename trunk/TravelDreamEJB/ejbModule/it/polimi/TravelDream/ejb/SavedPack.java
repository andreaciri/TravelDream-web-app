package it.polimi.TravelDream.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SAVED_PACK database table.
 * 
 */
@Entity
@Table(name="SAVED_PACK")
@NamedQuery(name="SavedPack.findAll", query="SELECT s FROM SavedPack s")
public class SavedPack implements Serializable {
	private static final long serialVersionUID = 1L;

	public SavedPack() {
	}
	
	@EmbeddedId SavedPackPK primaryKey;
	
	@Embeddable public static class SavedPackPK implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int idPackage;
		private String username;
		public int hashCode() {
	        return (int) username.hashCode() + idPackage;
	    }

		public int getIdPackage() {
			return this.idPackage;
		}

		public void setIdPackage(int idPackage) {
			this.idPackage = idPackage;
		}

		public String getUsername() {
			return this.username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
		
	    public boolean equals(Object obj) {
	        if (obj == this) return true;
	        if (!(obj instanceof SavedPackPK)) return false;
	        SavedPackPK pk = (SavedPackPK) obj;
	        return pk.idPackage == idPackage && pk.username.equals(username);
	    }
	}

}