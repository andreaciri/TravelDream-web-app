package it.polimi.TravelDream.ejb.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the COMPONENT database table.
 * 
 */
@Entity
@NamedQuery(name="Component.findAll", query="SELECT c FROM Component c")
public class Component implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idComponent;

	private String description;

	private int idType;

	private String name;

	private int price;

	public Component() {
	}

	public int getIdComponent() {
		return this.idComponent;
	}

	public void setIdComponent(int idComponent) {
		this.idComponent = idComponent;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdType() {
		return this.idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}