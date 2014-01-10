package it.polimi.TravelDream.ejb.userManagement;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class UserDTO {
	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message="invalid email")
	private String email;
	
	@NotEmpty
    private String username;
	@NotEmpty
    private String password;
     
  
    public String getUsername() {
		return username;
	}
    public void setUsername() {
    	this.username = username;
    }


	public String getEmail() {
        return email;
    } 
 
    public void setEmail(String email) {
        this.email = email;
    }
  
    public String getPassword() {
        return password;
    }
     
    public void setPassword(String password) {
        this.password = password;
    }
     

}
