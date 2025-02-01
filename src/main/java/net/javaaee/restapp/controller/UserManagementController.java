package net.javaaee.restapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import net.javaaee.restapp.model.User;
import net.javaaee.restapp.service.UserManagementService;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management Controller", description = "API for managing users")
public class UserManagementController 
{
	@Autowired
	private UserManagementService userManagementService;
	
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) 
    {
        User user = userManagementService.getuserById(Long.parseLong(id));
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }	
    
    @GetMapping("/tmp/{id}")
    public String getTestResponse(@PathVariable Long id) 
    {
    	return "User ID is ->" + id;
    }
    

    @GetMapping("/")
    public List<User> getAllUser() 
    {
    	List<User> userList =userManagementService.getAllUsers();
    	
    	return userList; 
    }
    
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) 
    {
    	User createdUser = userManagementService.createUser(user);
    	return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}