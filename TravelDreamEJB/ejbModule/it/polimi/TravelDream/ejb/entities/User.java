package it.polimi.TravelDream.ejb.entities;



import it.polimi.TravelDream.ejb.userManagement.dto.UserDTO;

import java.io.Serializable;

import javax.persistence.*;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String email;

	private String password;

public static final String FIND_ALL = "User.findAll";
	
	@ElementCollection(targetClass = Group.class)
    @CollectionTable(name = "USER_GROUP",
                    joinColumns = @JoinColumn(name = "username"))
    @Enumerated(EnumType.STRING)
    @Column(name="idGroup")
    private List<Group> group;


	//bi-directional many-to-many association to Package
	@ManyToMany
	@JoinTable(name="SAVED_PACK", 
		joinColumns={@JoinColumn(name="username")},
		inverseJoinColumns={@JoinColumn(name="idPackage")})
	private List<Package> packages;
	
	@OneToMany(mappedBy="user")
	private List<PurchasedPack> purchases;

	public User() {
		packages = new ArrayList<Package>();
	}
	
	public User(UserDTO user){
		this.username = user.getUsername();
        this.email = user.getEmail();       
        this.password = DigestUtils.sha256Hex(user.getPassword());
    }

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<Package> getPackages() {
		return this.packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}
	
	public void addPackage(Package pack) {
		packages.add(pack);
	}

	public List<Group> getGroup() {
		return this.group;
	}

	public void setGroup(List<Group> group) {
		this.group = group;
	}
	
}