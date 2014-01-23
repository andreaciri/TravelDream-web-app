package it.polimi.TravelDream.ejb.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


/**
 * The persistent class for the COMPONENT database table.
 * 
 */
@Entity
@Table(name="COMPONENT")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="idType", discriminatorType=DiscriminatorType.STRING)
@NamedQueries({
	@NamedQuery(name=Component.FIND_ALL, query="SELECT c FROM Component c"),
	@NamedQuery(name=Component.FIND_FLIGHTS, query="SELECT c FROM Component c WHERE c.idType='FLG'"),
	@NamedQuery(name=Component.FIND_HOTELS, query="SELECT c FROM Component c WHERE c.idType='HTL'"),
	@NamedQuery(name=Component.FIND_EXCS, query="SELECT c FROM Component c WHERE c.idType='XCR'")
})
public class Component implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Component.findAll";
	public static final String FIND_HOTELS = "Component.findHotels";
	public static final String FIND_FLIGHTS = "Component.findFlights";
	public static final String FIND_EXCS = "Component.findExcursions";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idComponent;

	private String description;

	@Column(nullable=false)
	private String idType;

	@Column(nullable=false)
	private String name;

	@Column(nullable=false)
	private int price;
	
	@ManyToMany(mappedBy="components", cascade=CascadeType.ALL)
	private Set<Package> packages;

	public Component() {
	}
	
	public Component(String name, String description, int price, int idComponent, String idType) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.idComponent = idComponent;
		this.idType = idType;
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

	public String getIdType() {
		return this.idType;
	}

	public void setIdType(String idType) {
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