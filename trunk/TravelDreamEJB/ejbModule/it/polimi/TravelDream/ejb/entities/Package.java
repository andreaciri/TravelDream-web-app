package it.polimi.TravelDream.ejb.entities;

import it.polimi.TravelDream.ejb.packageManagement.dto.PackageDTO;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the PACKAGE database table.
 * 
 */
@Entity
@Table(name="PACKAGE")
@NamedQueries({
	@NamedQuery(name="Package.findAllStandard", query="SELECT p FROM Package p where p.type='standard'"),
	@NamedQuery(name="Package.getPackageById", query="SELECT p FROM Package p WHERE p.idPackage = :idPackage")
})

public class Package implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idPackage")
	private int idPackage;
	@Column(name = "description")
	private String description;
	@Column(name = "title")
	private String title;
	@Column(name = "type")
	private String type;

	public static final String FIND_ALL_STANDARDP = "Package.findAllStandard";
	public static final String FIND_PACKAGE_BY_ID = "Package.getPackageById";
	
	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="packages")
	private List<User> users;

	public Package(){
	}
	
	public Package(PackageDTO p){
        this.description = p.getDescription();       
        this.title = p.getTitle();
        this.type = p.getTitle();
        this.idPackage = p.getIdPackage();
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
	

}