package it.polimi.TravelDream.ejb.entities;

import java.io.Serializable;
import javax.persistence.*;
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

	//bi-directional many-to-one association to PurchasedPack
	@OneToMany(mappedBy="user")
	private List<PurchasedPack> purchasedPacks;

	//bi-directional many-to-one association to SavedPack
	@OneToMany(mappedBy="user")
	private List<SavedPack> savedPacks;

	//bi-directional one-to-one association to UserGroup
	@OneToOne(mappedBy="user")
	private UserGroup userGroup;

	public User() {
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

	public List<PurchasedPack> getPurchasedPacks() {
		return this.purchasedPacks;
	}

	public void setPurchasedPacks(List<PurchasedPack> purchasedPacks) {
		this.purchasedPacks = purchasedPacks;
	}

	public PurchasedPack addPurchasedPack(PurchasedPack purchasedPack) {
		getPurchasedPacks().add(purchasedPack);
		purchasedPack.setUser(this);

		return purchasedPack;
	}

	public PurchasedPack removePurchasedPack(PurchasedPack purchasedPack) {
		getPurchasedPacks().remove(purchasedPack);
		purchasedPack.setUser(null);

		return purchasedPack;
	}

	public List<SavedPack> getSavedPacks() {
		return this.savedPacks;
	}

	public void setSavedPacks(List<SavedPack> savedPacks) {
		this.savedPacks = savedPacks;
	}

	public SavedPack addSavedPack(SavedPack savedPack) {
		getSavedPacks().add(savedPack);
		savedPack.setUser(this);

		return savedPack;
	}

	public SavedPack removeSavedPack(SavedPack savedPack) {
		getSavedPacks().remove(savedPack);
		savedPack.setUser(null);

		return savedPack;
	}

	public UserGroup getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

}