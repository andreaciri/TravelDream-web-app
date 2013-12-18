package it.polimi.TravelDream.ejb;

import it.polimi.TravelDream.ejb.SavedPack.SavedPackPK;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the PACK_CONTENT database table.
 * 
 */
@Entity
@Table(name="PACK_CONTENT")
@NamedQuery(name="PackContent.findAll", query="SELECT p FROM PackContent p")
public class PackContent implements Serializable {
	private static final long serialVersionUID = 1L;

	public PackContent() {
	}
	
	@EmbeddedId PackContentPK primaryKey;
	
	@Embeddable public static class PackContentPK implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int idComponent;
		private int idPackage;
		public int hashCode() {
	        return (int) hashCode() + idPackage;
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


		
	    public boolean equals(Object obj) {
	        if (obj == this) return true;
	        if (!(obj instanceof SavedPackPK)) return false;
	        PackContentPK pk = (PackContentPK) obj;
	        return pk.idPackage == idPackage && pk.idComponent == idComponent;
	    }
	}

}