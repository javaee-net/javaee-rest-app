package net.javaaee.restapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaaee.restapp.model.User;
import net.javaaee.restapp.repository.UserRepository;

@Service
public class UserManagementService 
{

	@Autowired
	private UserRepository userRepository;
	
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    
    public User getuserById(Long id) {
    	User usr = userRepository.findById(id).orElse(null); 
        
    	if(usr == null) 
        {
        	System.out.println("User Does not Exist");
        }
    	return usr; 
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}

