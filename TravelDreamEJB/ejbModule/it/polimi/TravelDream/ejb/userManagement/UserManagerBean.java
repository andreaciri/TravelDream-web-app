package it.polimi.TravelDream.ejb.userManagement;

import java.util.ArrayList;
import java.util.List;

import it.polimi.TravelDream.ejb.entities.*;
import it.polimi.TravelDream.ejb.userManagement.dto.UserDTO;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class UserManagerBean
 */
@Stateless
@LocalBean
public class UserManagerBean implements UsrMgr{
	
	//Vedere video 2 minuto 33
	
	@PersistenceContext
    private EntityManager em;
	
	@Resource
	private EJBContext context;
	

	@Override
	public void save(UserDTO user) {
		User newUser = new User(user);
		List<Group> group = new ArrayList<Group>();
		group.add(Group.USER); //solo i clienti si registrano
		newUser.setGroup(group);
		em.persist(newUser);
	}


	@Override
	@RolesAllowed({Group._USER,Group._ADMIN})
	public void update(UserDTO user) {
		em.merge(new User(user));
	}


	@Override
	@RolesAllowed({Group._USER,Group._ADMIN})
	public UserDTO getUserDTO() {
		UserDTO userDTO = convertToDTO(getPrincipalUser());
		return userDTO;
	}


	@Override
	@RolesAllowed({Group._USER})
	public void unregister() {
		remove(getPrincipalUser());
	}


	public User find(String username) {
    	return em.find(User.class, username);
    }
    
    public List<User> getAllUsers() {
    	return em.createNamedQuery(User.FIND_ALL, User.class)
                .getResultList();
    }

    public void remove(String username) {
		User user = find(username);
        em.remove(user);
	}
    
    public void remove(User user) {
    	em.remove(user);
	}
    
    
    public User getPrincipalUser() {
    	return find(getPrincipalUsername());
    }
	
    
    //RECUPERA L'UTENTE LOGGATO NEL CONTESTO CORRENTE E RECUPERA INFO
    public String getPrincipalUsername() {
    	return context.getCallerPrincipal().getName();
    }

    private UserDTO convertToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail(user.getEmail());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		return userDTO;
	}

}
