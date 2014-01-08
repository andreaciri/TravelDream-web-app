package it.polimi.TravelDream.ejb.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the COMPONENT_TYPE database table.
 * 
 */
@Entity
@Table(name="COMPONENT_TYPE")
@NamedQuery(name="ComponentType.findAll", query="SELECT c FROM ComponentType c")
public class ComponentType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idType;

	private String type;

	public ComponentType() {
	}

	public int getIdType() {
		return this.idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}