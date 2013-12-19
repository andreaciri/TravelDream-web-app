package it.polimi.TravelDream.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USER_GROUP database table.
 * 
 */
@Entity
@Table(name="USER_GROUP")
@NamedQuery(name="UserGroup.findAll", query="SELECT u FROM UserGroup u")
public class UserGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String group;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="username")
	private User user;

	public UserGroup() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}