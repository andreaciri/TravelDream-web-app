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

	@EmbeddedId
	private SavedPackPK id;

	public SavedPack() {
	}

	public SavedPackPK getId() {
		return this.id;
	}

	public void setId(SavedPackPK id) {
		this.id = id;
	}

}