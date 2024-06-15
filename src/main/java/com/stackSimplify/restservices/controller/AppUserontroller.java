package com.stackSimplify.restservices.controller;

import org.springframework.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.stackSimplify.restservices.Exceptions.UserExistsException;
import com.stackSimplify.restservices.Exceptions.UserNotFoundException;
import com.stackSimplify.restservices.entities.AppUsers;
import com.stackSimplify.restservices.service.AppUserService;

@RestController
public class AppUserontroller {
	
	@Autowired
	private AppUserService userService;
	
	@GetMapping("/findAllUsers")
	public List<AppUsers> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	@PostMapping("/createUser")
    public ResponseEntity createAppUser(@RequestBody AppUsers user, UriComponentsBuilder builder) {
		try {
		userService.createUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/getUserById/{userId}").buildAndExpand(user.getUserID()).toUri());
		return new ResponseEntity(headers,HttpStatus.CREATED);
		} 
		catch(UserExistsException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping("/getUserById/{userId}")
	public Optional<AppUsers> getUserById(@PathVariable Long userId){
		try {
		return userService.getUserById(userId);
		} 
		catch(UserNotFoundException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@PutMapping("/updateUserById/{userId}")
	public AppUsers updateUserById(@PathVariable("userId") Long userId, @RequestBody AppUsers user)
	{
		try {
		return userService.updateUser(userId, user);
		} catch(UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage()); 
		}
	}
	
	@DeleteMapping("/deleteUserById/{userId}")
	public void deleteUserById(@PathVariable ("userId") Long userId) {
		userService.deleteUserById(userId);
	}
	
	@GetMapping("/getUserByUserName/{userName}")
	public Optional<AppUsers> getUserByUserName(@PathVariable("userName") String userName) {
		return userService.getUserByUserName(userName);
	}

}
