package it.polimi.TravelDream.ejb.entities;

import it.polimi.TravelDream.ejb.packageManagement.dto.PackageDTO;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the PACKAGE database table.
 * 
 */
@Entity
@Table(name="PACKAGE")
@NamedQueries({
	@NamedQuery(name="Package.findAllStandard", query="SELECT p FROM Package p WHERE p.type='standard'"),
	@NamedQuery(name="Package.getPackageById", query="SELECT p FROM Package p WHERE p.idPackage = :idPackage"),
	@NamedQuery(name="Package.getCustomPackageById", query="SELECT p FROM Package p WHERE (p.idPackage = :idPackage) AND (p.type='custom')"),
	@NamedQuery(name="Package.getStandardPackageByKeyword", query="SELECT p FROM Package p WHERE (p.type='standard') AND (p.title like :keyword)")
})

public class Package implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idPackage")
	private int idPackage;
	@Column(name = "description")
	private String description;
	@Column(name = "title")
	private String title;
	@Column(name = "type")
	private String type;
	
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="PACK_CONTENT", 
			joinColumns={@JoinColumn(name="idPackage", referencedColumnName="idPackage")},
			inverseJoinColumns={@JoinColumn(name="idComponent", referencedColumnName="idComponent")})
	private List<Component> components;

	public static final String FIND_ALL_STANDARDP = "Package.findAllStandard";
	public static final String FIND_PACKAGE_BY_ID = "Package.getPackageById";
	public static final String FIND_CPACKAGE_BY_ID = "Package.getCustomPackageById";
	public static final String FIND_SPACKAGE_BY_KEY = "Package.getStandardPackageByKeyword";
	
	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="packages", cascade=CascadeType.MERGE)
	private List<User> users;

	public Package(){
	}
	
	public Package(PackageDTO p){
        this.description = p.getDescription();       
        this.title = p.getTitle();
        this.type = p.getType();
        components = new ArrayList<Component>();
    }
	
	public int getIdPackage() {
		return this.idPackage;
	}

	public void setIdPackage(int idPackage) {
		this.idPackage = idPackage;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	public void addComponent(Component c){
		components.add(c);
	}

}