package it.polimi.TravelDream.ejb.entities;

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

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="username")
	private User user;

	public SavedPack() {
	}

	public SavedPackPK getId() {
		return this.id;
	}

	public void setId(SavedPackPK id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}