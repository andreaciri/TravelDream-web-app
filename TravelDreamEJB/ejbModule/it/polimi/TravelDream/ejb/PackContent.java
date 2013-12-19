package it.polimi.TravelDream.ejb;

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

	@EmbeddedId
	private PackContentPK id;

	public PackContent() {
	}

	public PackContentPK getId() {
		return this.id;
	}

	public void setId(PackContentPK id) {
		this.id = id;
	}

}